#!/usr/bin/env bash

DB_USER="dbuser"
DB_PW="change_me"

echo ".: Starting the database :."
docker run -it --rm \
    -p 5432:5432 \
    -e POSTGRES_USER="${DB_USER}" \
    -e POSTGRES_PASSWORD="${DB_PW}" \
    -e POSTGRES_DB=micro \
    postgres:11.5-alpine
