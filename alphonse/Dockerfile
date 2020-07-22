FROM gradle:jdk11 as builder

ADD . /app
RUN cd /app && ./gradlew clean assembleDist

FROM openjdk:11-jre-slim
RUN apt-get update && apt-get install -y zip

RUN mkdir /app
COPY --from=builder /app/build/distributions/*zip /app/app.zip
WORKDIR /app
RUN unzip app.zip
WORKDIR /app/app-0.0.1-SNAPSHOT/
ENV JAVA_OPTS "-Dhttps.proxyHost=igotta -Dhttps.proxyPort=3128 -Dnewrelic.config.app_name=alphonse -javaagent:/agent/newrelic.jar"
ENTRYPOINT bin/app
