#!/usr/bin/env bash

HOST="$1"

curl -v -X "POST" "http://localhost:8080/api/users" \
 -H "Content-Type: application/json; charset=utf-8" \
 -d $'{"name":"","email":"","group":"abc","active":true,"tags":["jiri-user", "demo-user"]}'
