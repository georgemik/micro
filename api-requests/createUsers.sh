#!/usr/bin/env bash

if [[ -z "$1" ]]; then
  HOST="localhost"
else
  HOST="$1"
fi

curl -v -X "POST" "http://${HOST}:8080/api/users" \
  -H "Content-Type: application/json; charset=utf-8" \
  -d $'{"name":"Homer Simpson","email":"homer.simpson@gmail.com","groups":["users", "administrators"],"active":true,"tags":["Male", "D\'oh", "Bald", "Duff", "Donut"]}'

curl -v -X "POST" "http://${HOST}:8080/api/users" \
  -H "Content-Type: application/json; charset=utf-8" \
  -d $'{"name":"Moe Szyslak ","email":"moe@yahoo.com","groups":["users"],"active":true,"tags":["Bartender", "Male", "Moe\'s Tavern"]}'

curl -v -X "POST" "http://${HOST}:8080/api/users" \
  -H "Content-Type: application/json; charset=utf-8" \
  -d $'{"name":"Barnard Arnold Gumble","email":"bgumble@facebook.com","groups":["auditors", "users"],"active":true,"tags":["Mr. Plow", "Drunk", "Duff", "Beer"]}'

curl -v -X "POST" "http://${HOST}:8080/api/users" \
  -H "Content-Type: application/json; charset=utf-8" \
  -d $'{"name":"Bart Simpson","email":"bart.simpson@facebook.com","groups":["guests"],"active":true,"tags":["Bartholomew JoJo Simpson", "Kid", "¡Ay, caramba!" ]}'
