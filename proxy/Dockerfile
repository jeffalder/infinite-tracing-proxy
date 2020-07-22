FROM ubuntu:latest

RUN apt-get update
RUN TZ="Etc/UTC" DEBIAN_FRONTEND="noninteractive" apt-get install -y squid vim curl 

ADD ./squid.conf /etc/squid/squid.conf

ENTRYPOINT /usr/sbin/squid --foreground

