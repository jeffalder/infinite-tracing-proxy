# Infinite Tracing on New Relic Edge - Proxy

This docker-compose project simulates two services and a proxy. One service, alphonse, continuously loops, making http requests to gaston. Both services are instrumented.

There's also a squid proxy. The docker-compose file is designed to block access to outside services from all containers except the proxy.

## How to configure a proxy for Infinite Tracing on New Relic Edge

Add the following system properties to your java command-line: `https.proxyHost` and `https.proxyPort`. You can see them used in alphonse/Dockerfile and gaston/Dockerfile.

This setup works for this use case. It may not work if you have an authenticated proxy. And be aware that your proxy will need to support HTTP/2.

## How to run this reproduction case

1. Download `newrelic.jar` from the New Relic website. The Dockerfiles expect it to be named `newrelic.jar`.
2. Configure `agent/newrelic.yml` with your license key. If you want to test with Infinite Tracing, be sure to set your trace observer as well.
3. Run `docker-compose up`.