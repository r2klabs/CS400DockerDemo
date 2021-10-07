FROM openjdk:11
RUN useradd echosrv
RUN mkdir -p /usr/src/echoserver
RUN chown echosrv /usr/src/echoserver
USER echosrv
COPY *.java /usr/src/echoserver/
WORKDIR /usr/src/echoserver
RUN javac *.java
CMD ["java", "LaunchServer"]
EXPOSE 4445/udp
