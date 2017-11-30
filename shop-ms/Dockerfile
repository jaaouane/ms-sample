FROM tomcat:8.0.32-jre8

USER root

# add directly the war
COPY ./target/*.jar /shop-ms.jar

RUN sh -c 'touch /shop-ms.jar'

#create group and user ms-sample
RUN groupadd -g 2005 -r ms-sample \
&& useradd -u 2005 -g ms-sample -c 'ms-sample' ms-sample \
&& chown ms-sample /shop-ms.jar

#create logs directory mentioned in logback.xml
RUN mkdir -p  /applis/ms-sample/logs/shop-ms

#  chown ms-sample:ms-sample -R /applis/ms-sample/logs/shop-ms sera exécuté seulement sur la machine hote(pas besoin dans le conteneur)

EXPOSE 8081

USER ms-sample

CMD echo "The application will start ..." && \
    sleep 60  && \
    java -Dfile.encoding=UTF-8 -Djava.security.egd=file:/dev/./urandom -jar /shop-ms.jar
