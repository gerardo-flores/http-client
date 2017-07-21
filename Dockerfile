FROM java:8
ADD  /app.jar /app.jar
EXPOSE 8900
ENTRYPOINT ["java","-Dhttp.proxyHost=c1184651648.saasprotection.com","-Dhttps.proxyHost=c1184651648.saasprotection.com",\
"-Dhttp.proxyPort=8080","-Dhttps.proxyPort=8080","-Djava.net.useSystemProxies=true","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
