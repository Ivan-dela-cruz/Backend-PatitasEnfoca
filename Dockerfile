FROM openjdk:8-jre-alpine

RUN mkdir -p /usr/backendpatitas/bin /usr/backendpatitas/logs \
		&& chmod -R 775 /usr/backendpatitas

WORKDIR /usr/backendpatitas

ENV DATABASE=enfoca
ENV POSTGRESDB=127.0.0.1:5432

COPY target/spring-boot-data-jpa-0.0.1.jar .

RUN chmod 775 spring-boot-data-jpa-0.0.1.jar

CMD ["java", "-jar", "spring-boot-data-jpa-0.0.1.jar","--spring.config.location=file:///usr/backendpatitas/bin/application.yml"]

EXPOSE 8080
