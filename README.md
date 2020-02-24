# flag-picker
flag-picker-microservice-sleuth-zipkin

instructions to run this project
=================================
1. clone this project from git
2. refresh and update maven project to make sure all dependencies are downloaded successfully
3. This project has 3 api methods listed in the controller
                /picker/allContinents
                /picker/countries/{continent}
                /picker/flag/{continent}/{country}
4. This project is running on default port number 8080
5. Please run the applicattion using URL : http://localhost:8080/picker/allContinents
6. The Sleuth dependecy is added to project to generate log tracing
7. To see the tracing of api calls, please clone another project zipkin-server from git and start the zipkin server
8. zipkin server will run on port 9411 : http://localhost:9411/zipkin/
9. The Junits are implemented for Controller methods as well as for service methods. When you run the Junit for controller methods, it will run the spring context too. WHen you run the Junit for service classes it does not run the spring context

