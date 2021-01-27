FROM anapsix/alpine-java:8_jdk
RUN mkdir -p /home/wb-cloud/wb-docker-example
WORKDIR /home/wb-cloud/wb-docker-example
ADD wb-docker-example.jar /home/wb-cloud/wb-docker-example/app.jar
RUN bash -c 'touch /user/local/wb/wb-docker-example/app.jar'
ENTRYPOINT exec java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /home/wb-cloud/wb-docker-example/app.jar
