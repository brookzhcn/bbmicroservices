#!/usr/bin/env bash

echo "rename auth config files"
mv  auth-service/src/main/resources/bootstrap.yml auth-service/src/main/resources/bootstrap-prod.yml
mv  auth-service/src/main/resources/bootstrap-bak.yml auth-service/src/main/resources/bootstrap.yml
echo "rename auth finished"


