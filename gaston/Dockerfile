FROM gradle:jdk11 as builder

ADD . /app
RUN cd /app && ./gradlew bootJar

FROM openjdk:11-jre-slim

COPY --from=builder /app/build/libs/*jar app.jar

# The properties that configure the proxy for Infinite Tracing are the first two.
ENTRYPOINT java -Dhttps.proxyHost=igotta -Dhttps.proxyPort=3128 -Dnewrelic.config.app_name=gaston -javaagent:/agent/newrelic.jar -jar app.jar
