#!/bin/bash
sudo apt-get update 
sudo apt-get install openjdk-7-jre
sudo apt-get install openjdk-7-jdk
sudo apt-get install junit 
sudo apt-get install maven 
sudo apt-get install tomcat7
sudo apt-get install git
git clone https://the_real_mingo@bitbucket.org/the_real_mingo/cs445-fall-2015.git
cd cs445-fall-2015
cd Project 
cd src 
cd main 
cd java
sudo javac sad/*.java 
sudo javac system/*.java
sudo javac test/*.java 
sudo java -cp .:/usr/share/java/junit4-4.10.jar test/*.java
cd .. 
cd ..
cd ..
sudo mvn war:war
cd target 
sudo /etc/init.d/tomcat7 stop
sudo cp system.SAD.war /var/lib/tomcat7/webapps
sudo /etc/init.d/tomcat7 start
