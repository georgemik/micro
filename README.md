## Educational project
Learn Micronaut.
Application runs on _localhost:8080_. It's implementation of simple CRUD operation of user entity. 

## Building the application
Run `./build.sh`. (Builds the maven project and Docker container)

## Running the application
The database connection is defined by environmental variables passed to the application. 
If the variables are not defined it starts embedded H2 database. 

Environmental variables are defined in _micro/src/main/resources/application.yml_.

### Running with embeded H2 database
Run `./runMicroAppH2.sh`.

### Running with external PostgreSQL database
1. Start the DB via `./runDb.sh`. 
   Or run any PostgreSQL instance and pass env vars to the container/application.
2. Start the app running `./runMicroAppH2.sh <HOST>`.
