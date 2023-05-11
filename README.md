# WeatherMap React and Springboot Microservices
This is a project consisting of 3 microservices built with Spring Boot and 1 microservice built with React as the UI. The project allows users to retrieve weather information for a specified location.

#Microservices

##Service Registry

The service registry is responsible for registering and tracking the location of all the microservices in the system. It is built using the Spring Cloud Eureka server. All the other microservices will register with the service registry on startup and will be able to discover other microservices by querying the registry.

##WeatherMapAPI

The WeatherMapAPI microservice is responsible for fetching weather information from OpenWeatherMap API. It is built using the Spring Web and Spring Cloud Netflix Eureka Discovery Client libraries. When a request is made to retrieve weather information for a particular location, this microservice will query the OpenWeatherMap API and return the weather data.

##WeatherMapClient

The WeatherMapClient microservice is responsible for handling requests from the UI microservice for weather information. It is built using Spring Web and Spring Cloud Netflix Eureka Discovery Client libraries. When a request is made for weather information for a particular location, the WeatherMapClient microservice will query the WeatherMapAPI microservice and return the weather data.

##UI Microservice

The UI microservice is responsible for displaying the weather information to the user. It is built using React and communicates with the WeatherMapClient microservice to retrieve weather information for a particular location.

##Usage

To retrieve weather information for a location, enter the location in the search bar on the UI and click the search button. The UI will display the current weather information for the location.

##Credits

The following libraries were used in the project:

Spring Boot
Spring Cloud Netflix Eureka
Spring Web
React
OpenWeatherMap API


##License

This project is open for public usage under open source licensed.
