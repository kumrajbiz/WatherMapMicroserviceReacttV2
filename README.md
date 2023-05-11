# WeatherMap React and Springboot Microservices

This system provides an efficient and scalable way of retrieving and displaying weather information to users. Its microservice architecture allows for each service to be developed and deployed independently, enabling faster iteration and development.
This is a project consisting of 3 microservices built with Spring Boot and 1 microservice built with React as the UI. The project allows users to retrieve weather information for a specified location.

# WeatherMap Sequence diagram

![WeatherMapSequence](https://github.com/kumrajbiz/WatherMapMicroserviceReacttV2/blob/prod/WeatherMapSequence.png)

# Architecture

The system follows a microservice architecture pattern, where each service is responsible for a specific function and communicates with other services using RESTful APIs.

## Weather Map Client

The weather map client is responsible for handling user requests for weather information. It validates the user input to ensure it contains only alphabetic characters and then sends a request     to the weather map API.

## Weather Map API

The weather map API is responsible for communicating with the OpenWeatherMap API to retrieve weather information for the specified location. It processes the response and stores it in JSON format before sending it back to the weather map client.

## Service Registry

The Eureka server is a service registry and discovery server that enables services to find and communicate with each other.

## React UI

The React-based UI provides users with a graphical interface for requesting weather information. based on request/response with the weather map client. Info provided in form of JSON or XML format and processed further at UI.
HTML Based UI is also available within this project as a base version of UI development further upgraded to React. 
```
Url for Html : http://localhost:8888/static/index.html
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

## CICD Integration

### Jenkins
    
Pipeline scripts loacted at pipeline/jenkins
        
### AWS
    
Pipeline scripts loacted at pipeline/aws


## License

This project is open for public usage under open source licensed.
