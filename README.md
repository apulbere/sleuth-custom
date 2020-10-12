# About
POC for `X-Correlation-ID` to `traceId` and `spanId`

Log format `[application name, traceId, spanId, export]`

Request:
```
curl --location --request GET 'localhost:8080' \
--header 'X-Correlation-ID: 1c32ea85-066e-4453-9c02-eb18bf6b9717'
```

Result from logs:
```
2020-10-12 22:03:06.061  INFO [sleuth-custom,000000001c32ea85,000000000000066e,false] 6668 --- [nio-8080-exec-1] c.a.sleuthcustom.web.HelloController     : hi there log
```