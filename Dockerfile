FROM openjdk:17
COPY . /build/libs/
WORKDIR /build/libs/
EXPOSE 8081
ENV TZ=America/Bogota
RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone
CMD ["java","-jar","build/libs/sibun_mq-0.0.1-SNAPSHOT.jar"]