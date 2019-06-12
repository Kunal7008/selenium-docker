FROM openjdk:8

WORKDIR /usr/share/udemy
ADD target/selenium-docker.jar           selenium-docker.jar
ADD target/selenium-docker-tests.jar     selenium-docker-tests.jar
ADD target/libs     					 libs


ADD Come.xml                             Come.xml
ADD book-flight-module.xml                book-flight-module.xml

ENTRYPOINT java -cp selenium-docker.jar;selenium-docker-tests.jar;libs/* -DBROWSER=$BROWSER _DHUB_HOST=$HUB_HOST org.testng.TestNG $MODULE   
