#!/usr/bin/env bash

HOST="$1"

curl -v -X "POST" "http://${HOST}:8080/api/users" \
 -H "Content-Type: application/json; charset=utf-8" \
 -d $'{"name":"jiri","email":"jiri@jiri.com","group":"abc","active":true,"tags":["jiri-user", "demo-user"]}'


curl -v -X "POST" "http://${HOST}:8080/api/users" \
 -H "Content-Type: application/json; charset=utf-8" \
 -d $'{"name":"jan","email":"jan@jan.com","group":"abc","active":true,"tags":["jan-user", "demo-user"]}'


curl -v -X "POST" "http://${HOST}:8080/api/users" \
 -H "Content-Type: application/json; charset=utf-8" \
 -d $'{"name":"peter","email":"abc@def.com","group":"abc","active":true,"tags":["peter-user", "auditors"]}'