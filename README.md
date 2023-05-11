# WeatherMap React and Springboot Microservices
This system provides an efficient and scalable way of retrieving and displaying weather information to users. Its microservice architecture allows for each service to be developed and deployed independently, enabling faster iteration and development.
This is a project consisting of 3 microservices built with Spring Boot and 1 microservice built with React as the UI. The project allows users to retrieve weather information for a specified location.

# WeatherMap Sequence diagram
```
![WeatherMapSequence](https://github.com/kumrajbiz/WatherMapMicroserviceReacttV2/blob/prod/WeatherMapSequence.png)
```

# Architecture
```
The system follows a microservice architecture pattern, where each service is responsible for a specific function and communicates with other services using RESTful APIs.
```
## Weather Map Client
```
The weather map client is responsible for handling user requests for weather information. It validates the user input to ensure it contains only alphabetic characters and then sends a request to the weather map API.
```
## Weather Map API
```
The weather map API is responsible for communicating with the OpenWeatherMap API to retrieve weather information for the specified location. It processes the response and stores it in JSON format before sending it back to the weather map client.
```
## Service Registry
```
The Eureka server is a service registry and discovery server that enables services to find and communicate with each other.
```
## React UI
```
The React-based UI provides users with a graphical interface for requesting weather information. based on request/response with the weather map client. Info provided in form of JSON or XML format and processed further at UI.

HTML Based UI is also available within this project as a base version of UI development further upgraded to React. 
```
Url for Html : http://localhost:8888/static/index.html
```
```




## License

This project is open for public usage under open source licensed.
