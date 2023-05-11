## Hamed Mohseni
### hamohseni@unal.edu.co

## Documentation

## Gradle Build
``` ./gradlew build && java -jar build/libs/gs-spring-boot-docker-0.1.0.jar ```
## Build the image
``` docker build -t hamohseni/sibun_mq .  ```
## Push new image to docker hub
``` docker push hamohseni/sibun_mq ```
## Run image
``` docker run -p 8081:8081 hamohseni/sibun_mq ```
## Run RabbitMQ server
``` docker run --rm -it --hostname sibun-mq -p 15672:15672 -p 5672:5672 -e RABBITMQ_DEFAULT_USER=user -e RABBITMQ_DEFAULT_PASS=password rabbitmq:3-management ```
