#!/usr/bin/env bash

echo "rename auth config files"
mv  auth-service/src/main/resources/bootstrap.yml auth-service/src/main/resources/bootstrap-bak.yml
mv  auth-service/src/main/resources/bootstrap-prod.yml auth-service/src/main/resources/bootstrap.yml
echo "rename auth finished"


