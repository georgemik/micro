#!/usr/bin/env bash

HOST="$1"

curl -v -X "GET" "http://${HOST}:8080/api/users"