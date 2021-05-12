#!/usr/bin/env bash

HOST="$1"

curl -v -X "POST" "http://localhost:8080/api/users" \
 -H "Content-Type: application/json; charset=utf-8" \
 -d $'{"name":"as","email":"a@a","group":["administrators", "users", "abc"],"active":true,"tags":["jiri-user", "demo-user"]}'
