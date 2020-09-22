# How to Build and Execute


## Build Native Image with GraalVM


```bash
$ git switch native-image

# build dockage image
$ mvn spring-boot:build-image
# or ./mvnw spring-boot:build-image

# execute application
$ docker run -it -p 8080:8080 build-image:0.0.1-SNAPSHOT
```

Access http://localhost:8080/greet and you are able to get response.