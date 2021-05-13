#!/usr/bin/env bash

if [[ -z "$1" ]]; then
  HOST="localhost"
else
  HOST="$1"
fi

curl -v -X "POST" "http://localhost:8080/api/users" \
 -H "Content-Type: application/json; charset=utf-8" \
 -d $'{"name":"as","email":"a@a","group":["administrators", "users", "abc"],"active":true,"tags":["jiri-user", "demo-user"]}'
