FROM openjdk:11.0.2-jre-slim

ENV JAR_FILE=addressline.jar

RUN export DEBIAN_FRONTEND=noninteractive

RUN apt-get install -y tzdata

RUN dpkg-reconfigure --frontend noninteractive tzdata

ADD addressline-application/target/${JAR_FILE} /app/

ENTRYPOINT [ "sh", "-c", "java -Xmx1g -jar /app/${JAR_FILE}" ]