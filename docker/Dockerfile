####
# This Dockerfile is used in order to build a container that runs the Spring Boot application
#
# Build the image with:
#
# docker build -f docker/Dockerfile -t springboot/sample-demo .
#
# Then run the container using:
#
# docker run -i --rm -p 8081:8081 springboot/sample-demo
####
FROM quay.io/devfile/maven:3.8.1-openjdk-17-slim

WORKDIR /build

# Build dependency offline to streamline build
COPY pom.xml .
RUN mvn dependency:go-offline

COPY src src
RUN mvn package -Dmaven.test.skip=true 
# compute the created jar name and put it in a known location to copy to the next layer.
# If the user changes pom.xml to have a different version, or artifactId, this will find the jar 
RUN grep version /build/target/maven-archiver/pom.properties | cut -d '=' -f2 >.env-version 
RUN grep artifactId /build/target/maven-archiver/pom.properties | cut -d '=' -f2 >.env-id
RUN mv /build/target/$(cat .env-id)-$(cat .env-version).jar /build/target/export-run-artifact.jar

FROM openjdk:11-jdk
COPY --from=0 /build/target/export-run-artifact.jar  /app/target/export-run-artifact.jar

EXPOSE 8081
ENTRYPOINT [ "java", "-jar", "/app/target/export-run-artifact.jar", "--server.port=8081" ]
