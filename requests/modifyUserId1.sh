#!/usr/bin/env bash

HOST="$1"

curl -v -X "PUT" "http://${HOST}:8080/api/users/1" \
 -H "Content-Type: application/json; charset=utf-8" \
 -d $'{"id": "1", "name":"jiri","email":"jiri-new@jiri.com","group":"abc","active":true,"tags":["jiri-user", "alert-user", "tag3", "tag4", "tag55"]}'