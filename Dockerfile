FROM java:8-alpine
ARG JAR_NAME
COPY "build/libs/${JAR_NAME}" "/usr/src/app/app.jar"
EXPOSE 8580 8581 8500
RUN echo ${JAR_NAME}
ENTRYPOINT ["java","-jar","/usr/src/app/app.jar"]
