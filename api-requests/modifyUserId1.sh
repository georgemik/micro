#!/usr/bin/env bash

if [[ -z "$1" ]]; then
  HOST="localhost"
else
  HOST="$1"
fi

curl -v -X "PUT" "http://${HOST}:8080/api/users/1" \
  -H "Content-Type: application/json; charset=utf-8" \
  -d $'{"id": "1", "name":"Homer Jay Simpson","email":"homer.simpson@yahoo.com","groups":["users"],"active":true,"tags":["Male", "D\'oh", "Bald"]}'
