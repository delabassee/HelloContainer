FROM openjdk:latest
WORKDIR /world
COPY src/main/java/HelloWorld.java /world
RUN javac HelloWorld.java -d .
CMD java HelloWorld