#!/usr/bin/env bash

echo ".: Build java application :."
mvn clean install || exit 1

echo ".: Build Docker image :."
docker build . -t docker.pkg.github.com/georgemik/micro/micro-app:latest -t docker.pkg.github.com/georgemik/micro/micro-app:1
