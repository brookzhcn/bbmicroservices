#!/usr/bin/env bash

echo "rename auth config files"
mv  auth-service/src/main/resources/bootstrap.yml auth-service/src/main/resources/bootstrap-bak.yml
mv  auth-service/src/main/resources/bootstrap-prod.yml auth-service/src/main/resources/bootstrap.yml
echo "rename auth finished"

echo "rename registry config files"
mv  registry/src/main/resources/bootstrap.yml auth-service/src/main/resources/bootstrap-bak.yml
mv  registry/src/main/resources/bootstrap-prod.yml auth-service/src/main/resources/bootstrap.yml
echo "rename registry finished"


echo "rename message config files"
mv  message/src/main/resources/bootstrap.yml auth-service/src/main/resources/bootstrap-bak.yml
mv  message/src/main/resources/bootstrap-prod.yml auth-service/src/main/resources/bootstrap.yml
echo "rename message finished"
