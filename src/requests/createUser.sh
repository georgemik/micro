#!/usr/bin/env bash

curl -v -X "POST" "http://localhost:8080/api/users" \
 -H "Content-Type: application/json; charset=utf-8" \
 -d $'{"name":"abc","email":"abc@def.com","group":"abc","active":true,"tags":["abc, def"]}'