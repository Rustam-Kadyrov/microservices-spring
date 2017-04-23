# Microservices with Spring

Project for presentation of microservices. It contains modules: 
* Configuration service - holds properties for all applications
* Registry service - registers services for further executing
* Order service - stores orders in Elasticsearch
* Customer service - stores customers in Postgresql database
* Dispatcher service - sends business events to queue  
* Routing service - one access point for external client, routes requests to services 

To clone, build and start application you need:
* Git client
* Java 8
* Maven 3
* Docker (for Windows 'Docker toolbox' is preferable)


# Build and start

Clone project

    git clone https://github.com/Rustam-Kadyrov/microservices-spring.git    
    
Build all modules and docker images for them

    cd microservices-spring
    mvn clean package docker:build

## Start infrastructure containers

Make sure that VM has enough memory (At least 2048 Mb is recommended).
Path Docker virtual machine with command:
    
    docker-machine ssh default "sudo sysctl -w vm.max_map_count=262144"

Run containers:

    docker-compose -f docker-compose-infrastructure.yml up -d

## Start business containers
    
    docker-compose -f docker-compose-business.yml up -d

# URLs
## Business services

Through routing service:

[Dispatcher service swagger](http://192.168.99.100:8082/dispatcher-service/swagger-ui.html)

[Customer service swagger](http://192.168.99.100:8082/customer-service/swagger-ui.html)

[Order service swagger](http://192.168.99.100:8082/order-service/swagger-ui.html)

## Eureka

[Link to UI](http://192.168.99.100:8761)

## Elastic search

[Status link](http://192.168.99.100:9200)

    login: elastic
    password: changeme
    

## Rabbit MQ

[Link to UI](http://192.168.99.100:15672)
 
    login: guest
    password: guest