#!/usr/bin/env bash

if [[ -z "$1" ]]; then
  HOST="localhost"
else
  HOST="$1"
fi

curl -v -X "GET" "http://${HOST}:8080/api/users"
