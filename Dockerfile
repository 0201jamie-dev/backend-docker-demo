FROM maven:3.9.12-eclipse-temurin-17 AS build

ENV JAVA_TOOL_OPTIONS=-Dfile.encoding=UTF8
WORKDIR /srv

RUN git clone https://github.com/0201jamie-dev/backend-docker-demo && \
    cd /srv/backend-docker-demo && mvn -B package -DskipTests


FROM eclipse-temurin:17-jre
WORKDIR /srv

COPY --from=build /srv/backend-docker-demo/target/*SNAPSHOT.jar /srv/app.jar

ENV DB_USER=sa
ENV DB_PASSWORD=123
ENV SPRING_DATASOURCE_URL=jdbc:h2:mem:taskdb
ENV SPRING_JPA_HIBERNATE_DDL_AUTO=update
ENV SPRING_JPA_PROPERTIES_HIBERNATE_DIALECT=org.hibernate.dialect.H2Dialect

CMD ["java","-jar","/srv/app.jar"]