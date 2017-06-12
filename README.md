# FastCatch

How to start the FastCatch application
---

1. Run `mvn clean install` to build your application
1. Copy config.example.yml to config.yml and change database values
1. Start application with `java -jar target/fastcatchAPi-1.0-SNAPSHOT.jar server config.yml`
1. To check that your application is running enter url `http://localhost:8080`
1. If you are using Inteliji IDE , Go to `Edit` configuration -> `Application` -> `Program Arguments` -> insert this value : `server ./config.yml` 

Health Check
---

To see your applications health enter url `http://localhost:8081/healthcheck`
