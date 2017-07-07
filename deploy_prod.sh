#!/bin/bash

ssh -v root@46.101.133.26 << EOF
cd /var/demoapp
/etc/init.d/demoapp stop
git checkout --force master
git pull
mvn package
mvn clean package
/etc/init.d/demoapp start
EOF
