#!/bin/bash

ssh -v root@46.101.133.26 << EOF
cd /root/javaapp/
git checkout --force master
git pull
mvn package
java -jar target/demo-0.0.1-SNAPSHOT.jar

echo 'Done'
EOF
