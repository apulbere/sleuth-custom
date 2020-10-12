package com.apulbere.sleuthcustom.web;

import brave.Span;
import brave.Tracer;
import brave.propagation.TraceContext;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.math.BigInteger;

@AllArgsConstructor
@Component
public class SleuthInterceptor extends HandlerInterceptorAdapter {

    private Tracer tracer;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String[] correlationId = request.getHeader("X-Correlation-ID").split("-");

        TraceContext traceContext = TraceContext.newBuilder()
                .traceId(new BigInteger(correlationId[0], 16).longValue())
                .spanId(new BigInteger(correlationId[1], 16).longValue())
                .build();

        Span span = tracer.toSpan(traceContext);

        tracer.withSpanInScope(span);
        return true;
    }
}
