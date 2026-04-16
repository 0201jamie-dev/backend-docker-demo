FROM maven:3.9.12-eclipse-temurin-17 AS build

ENV JAVA_TOOL_OPTIONS=-Dfile.encoding=UTF8
WORKDIR /srv

RUN git clone https://github.com/0201jamie-dev/backend-docker-demo && \
    cd /srv/backend-docker-demo && mvn -B package -DskipTests


FROM eclipse-temurin:17-jre
WORKDIR /srv

COPY --from=build /srv/backend-docker-demo/target/*.jar /srv/app.jar

ENV MARIADB_USER=root
ENV SPRING_DATASOURCE_URL=jdbc:mariadb://host.docker.internal:3306/taskdb
ENV SPRING_JPA_HIBERNATE_DDL_AUTO=update
ENV SPRING_JPA_PROPERTIES_HIBERNATE_DIALECT=org.hibernate.dialect.MariaDBDialect

CMD ["java","-jar","/srv/app.jar"]