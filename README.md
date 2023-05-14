# WeatherMap React and Springboot Microservices

This system provides an efficient and scalable way of retrieving and displaying weather information to users. Its microservice architecture allows for each service to be developed and deployed independently, enabling faster iteration and development.
This is a project consisting of 3 microservices built with Spring Boot and 1 microservice built with React as the UI. The project allows users to retrieve weather information for a specified location.

# WeatherMap Sequence diagram

[WeatherMapSequence](https://github.com/kumrajbiz/WatherMapMicroserviceReacttV2/blob/prod/WeatherMapSequence.png)
![WeatherMapSequence](https://github.com/kumrajbiz/WatherMapMicroserviceReacttV2/blob/prod/WeatherMapSequence.png)

# Architecture

The system follows a microservice architecture pattern, where each service is responsible for a specific function and communicates with other services using RESTful APIs.

## Service Registry

The service registry is responsible for registering and tracking the location of all the microservices in the system. It is built using the Spring Cloud Eureka server. All the other microservices will register with the service registry on startup and will be able to discover other microservices by querying the registry.

Localhost access to browser and postman : [http://localhost:8761](http://localhost:8761)\
Docker access to browser and postman : [http://172.18.0.2:8761/](http://172.18.0.2:8761/)

## Weather Map Client

The WeatherMapClient microservice is responsible for handling requests from the UI microservice for weather information. It is built using Spring Web and Spring Cloud Netflix Eureka Discovery Client libraries. When a request is made for weather information for a particular location, the WeatherMapClient microservice will query the WeatherMapAPI microservice and return the weather data.
There are two methodology integrate tested working first- RestTemplet and second - feigh client
Handle response internaly for UI display.

Localhost access to browser and postman : [http://localhost:8888/weather/paris](http://localhost:8888/weather/paris)\
Docker access to browser and postman : [http://172.18.0.4:8888/weather/paris](http://172.18.0.4:8888/weather/paris)


## Weather Map API

The WeatherMapAPI microservice is responsible for fetching weather information from api.openweathermap.org. It is built using the Spring Web and Spring Cloud Netflix Eureka Discovery Client libraries. When a request is made to retrieve weather information for a particular location, this microservice will query the api.openweathermap.org and return the weather data.

Localhost access to browser and postman : [http://localhost:8088/weather/paris()](http://localhost:8088/weather/paris)\
Docker access to browser and postman : [http://172.18.0.3:8088/weather/paris()](http://172.18.0.4:8088/weather/paris)



## React UI

The React-based UI provides users with a graphical interface for requesting weather information. based on request/response with the weather map client. Info provided in form of JSON or XML format and processed further at UI.
HTML Based UI is also available within this project as a base version of UI development further upgraded to React.
```
React Ui access Url through Browser http://localhost:1234/
```
```
Html UI access Url through Browser : http://localhost:8888/static/index.html
React UI access Url trhrough browser : http://172.18.0.5:1234/ 
```
## Api Data source
```
https://openweathermap.org/api
```
```
https://api.openweathermap.org/data/2.5/weather?q=${search}&units=metric&appid=a38f758c5edcf066e4c15e4bd4284d5c
```

# Project Feature 

## Swagger integration 

Swagger configured, it generates the API documentation automatically based on the annotations used in the controllers and models. The API documentation is accessible through the URL path,
Only accessible for project WeatherMapAPIv3-Mocroservice2 Microservice port will be 8888 and host depend on environmment. example localhost, docker IP and aws provided IP6 address.
```
http://{host}:{port}/swagger-ui.html
```
Docker based url for swagger : http://172.18.0.3:8088/swagger-ui.html#/
Where {host} and {port} are the host and port where the application is running.
For staging, Docker, Serverbased and AWS host will vary.

## Docker integration 

Docker implementation has been done for each microservice in the project. The Dockerfiles for each microservice are available at respective Project Folder directory of the repository.
and can be accessed locally or on AWS (configured locally with AWS CLI). 
Prepequesite 
1. create docker based local network
2. Running images with name and network option

### also

You can run the application locally using Docker Compose by running the ```s3/weathermap_dc_v3.yaml``` file with docker-compose file name up -d  in the root directory of the repository

### Alternatively,

you can deploy the application to an AWS environment using the AWS CLI. You'll need to configure the AWS CLI with your account credentials and region. Then, run the following commands:

bash
Copy code
```
./build-docker-images.sh
./deploy-to-ecs.sh
```
This will build the Docker images and deploy them to an Amazon Elastic Container Service (ECS) cluster.

## Onsite Production deployment 

WeatherApi app will get deployed to the ``` nginx server ``` 
Upgraded the reverse proxy for docker containers up in status
Server registry\
WeatherMap Api\
WeatherMap Client\
WeatherReact UI\
Log wil be availabe for Nginx server : /var/log/nginx/access.log, /var/log/nginx/error.log\
Dashboard will be availabe at :http://127.0.0.1/nginx_status

## CICD Integration

### Jenkins
    
Pipeline scripts loacted at pipeline/jenkins 
configuration and functionality  will be demonstrate at demo
        
### AWS
    
Pipeline scripts loacted at pipeline/aws
configuration and functionality  will be demonstrate at demo

### TravisCI

url : 


## License

This project is open for public usage under open source licensed.
