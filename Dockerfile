FROM public.ecr.aws/docker/library/openjdk:17us
WORKDIR /app
COPY ./target/course-service.jar /app
EXPOSE 8080
CMD ["java", "-jar", "course-serive.jar"]