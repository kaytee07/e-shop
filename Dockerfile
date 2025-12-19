FROM eclipse-temurin:17-jdk AS builder
WORKDIR /app

#cache maven wrapper script and configuaration
COPY .mvn/ .mvn
COPY mvnw pom.xml ./
RUN ./mvnw dependency:go-offline -B

#copy the source and build the fat jar
COPY src ./src
RUN ./mvnw clean package -DskipTests

#Stage 2
FROM eclipse-temurin:17-jdk AS extractor
WORKDIR /app
COPY --from=builder /app/target/*.jar app.jar
RUN java -Djarmode=tools -jar app.jar extract --layers --launcher --destination layers

#stage 3
FROM eclipse-temurin:17-jre
WORKDIR /app

#Best practice is to run as a non root user for security
RUN groupadd -r spring && useradd -r -g spring spring
USER spring

#copy layers from extractor stage
COPY --from=extractor /app/layers/dependencies/ ./
COPY --from=extractor /app/layers/spring-boot-loader/ ./
COPY --from=extractor /app/layers/snapshot-dependencies/ ./
COPY --from=extractor /app/layers/application/ ./

ENTRYPOINT ["java", "org.springframework.boot.loader.launch.JarLauncher"]