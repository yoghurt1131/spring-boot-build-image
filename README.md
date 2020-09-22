# How to Build and Execute


## Build Docker Image with Cloud Native Buildpacks


```bash
$ git switch cloud-native-buildpacks

# build dockage image
$ mvn spring-boot:build-image
# or ./mvnw spring-boot:build-image

# execute application
$ docker run -it -p 8080:8080 build-image:0.0.1-SNAPSHOT
```

Access http://localhost:8080/greet and you are able to get response.