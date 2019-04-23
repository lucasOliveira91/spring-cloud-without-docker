# Spring-Cloud - without docker

### Config Server
It's responsable to produce the configurations for the services, the configurations are store in a git repository.

### Ribbon (Netflix-Ribbon) 
It's responsable to make the loading balance, it will decide which instance of that service it'll send the request.
Naming Server (Eureka) 

### Naming Server (Eureka)
The services are registred in this server so them can be find indepedent how many instances that service can have.

### Gateway
It's responsible to intercept all request, in this point the authentication and authorization will be verified

### Sleuth
it makes an ID for each  requests

### Zipkin
This is responsible to get all trance from the services.
This solution needs a zipkin server and a MQ server like RabbitMQ
