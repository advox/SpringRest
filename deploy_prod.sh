#!/bin/bash

ssh -v root@46.101.133.26

echo '1. Updating sources'
cd /root/javaapp/
git checkout --force master
mvn package
java -jar target/demo-0.0.1-SNAPSHOT.jar
git pull

sudo apache2ctl graceful

echo 'Done!'

EOF