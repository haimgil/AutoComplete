FROM adoptopenjdk/openjdk11:aarch64-centos-jdk-11.0.6_10
ENV APP_HOME=/usr/app/
WORKDIR $APP_HOME
COPY target/autocomplete-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 9090
CMD ["java", "-jar", "app.jar", "--env NO_PROXY=*"]