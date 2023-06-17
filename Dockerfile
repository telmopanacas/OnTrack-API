# build environment
FROM maven as build
RUN mkdir /src
WORKDIR /src
ADD . .
RUN mvn package -Dmaven.test.skip

# production environment
FROM openjdk:17-slim
RUN mkdir /app
WORKDIR /app
COPY --from=build /src/target/api-0.0.1-SNAPSHOT.jar .
ENTRYPOINT ["java", "-jar", "api-0.0.1-SNAPSHOT.jar"]
