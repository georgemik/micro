#!/usr/bin/env bash

echo ".: Starting the micro app with H2 DB :."
docker run --rm -ti --name micronaut-app-h2 -p 8080:8080 docker.pkg.github.com/georgemik/micro/micro-app:latest
