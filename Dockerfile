FROM openjdk:8-jdk-alpine

LABEL source="https://github.com/fiap-69aoj-hackathon/donateverse-transaction" \
      maintainer="ewertondsdias@gmail.com"

ADD ./target/transaction-0.0.1-SNAPSHOT.jar transaction.jar
ADD ./docker-entrypoint.sh /

RUN chmod +x /docker-entrypoint.sh

EXPOSE 8083

ENTRYPOINT ["/docker-entrypoint.sh"]


