#!/bin/bash

git pull origin master

sudo javac -d ../WEB-INF/classes -cp ../WEB-INF/lib/postgresql-42.7.1.jar com/bjjranks/Database.java
sudo javac -d ../WEB-INF/classes -cp ../WEB-INF/lib/servlet-api.jar:/opt/tomcat/webapps/bjjranks/src com/bjjranks/Responder.java
sudo javac -d ../WEB-INF/classes -cp ../WEB-INF/lib/servlet-api.jar:/opt/tomcat/webapps/bjjranks/src com/bjjranks/Router.java
sudo javac -d ../WEB-INF/classes -cp ../WEB-INF/lib/servlet-api.jar:/opt/tomcat/webapps/bjjranks/src com/bjjranks/Servlet.java

systemctl restart apache2
systemctl restart tomcat
