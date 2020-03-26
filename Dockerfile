FROM openjdk:7u211-jdk-alpine3.9

LABEL source="https://github.com/fiap-69aoj-hackathon/donateverse-transaction" \
      maintainer="ewertondsdias@gmail.com"

ADD ./target/transaction-0.0.1-SNAPSHOT.jar transaction.jar
ADD ./docker-entrypoint.sh /

RUN chmod +x /docker-entrypoint.sh

EXPOSE 8081

ENTRYPOINT ["/docker-entrypoint.sh"]


