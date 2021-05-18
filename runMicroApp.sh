#!/usr/bin/env bash

DB_USER="dbuser"
DB_PW="change_me"
PG_DRIVER="org.postgresql.Driver"

[[ -z $1 ]] && echo -e "Host must be specified as a first argument. \nE.g. $0 localhost" && exit 1

echo ".: Starting the micro app connected to PSQL :."
docker run --rm -ti --name micronaut-app \
    -e JDBC_URL="jdbc:postgresql://$1:5432/micro" \
    -e JDBC_USER="${DB_USER}" \
    -e JDBC_PASSWORD="${DB_PW}" \
    -e JDBC_DRIVER="${PG_DRIVER}" \
    -p 8080:8080 docker.pkg.github.com/georgemik/micro/micro-app:latest
