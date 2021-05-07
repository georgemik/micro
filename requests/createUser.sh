#!/usr/bin/env bash

curl -v -X "POST" "http://localhost:8080/api/users" \
 -H "Content-Type: application/json; charset=utf-8" \
 -d $'{"name":"jiri","email":"abc@def.com","group":"abc","active":true,"tags":["abc, def"]}'


curl -v -X "POST" "http://localhost:8080/api/users" \
 -H "Content-Type: application/json; charset=utf-8" \
 -d $'{"name":"jan","email":"abc@def.com","group":"abc","active":true,"tags":["abc, def"]}'


curl -v -X "POST" "http://localhost:8080/api/users" \
 -H "Content-Type: application/json; charset=utf-8" \
 -d $'{"name":"peter","email":"abc@def.com","group":"abc","active":true,"tags":["abc, def"]}'