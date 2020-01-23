FROM java:8-jdk-alpine

COPY ./target/clientfacingserver-1.0.1.jar /usr/app/

WORKDIR /usr/app

RUN sh -c 'clientfacingserver-1.0.1.jar'

ENTRYPOINT ["java","-jar","clientfacingserver-1.0.1.jar"]