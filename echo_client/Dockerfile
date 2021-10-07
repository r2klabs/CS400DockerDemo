FROM openjdk:11
RUN useradd appuser
RUN mkdir -p /usr/src/myapp
RUN chown appuser /usr/src/myapp
USER appuser
COPY Example.java /usr/src/myapp
WORKDIR /usr/src/myapp
RUN javac Example.java
CMD ["java", "Example"]