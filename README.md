# Reservations-Service
## This just an example of using the listed technologies for learning purposes

This service is responsible to return the list of available reservations in the database

### Technologies
* Java 8
* Maven
* SpringBoot
* Lombok
* Swagger
* H2Database
* Jasypt

***

### How to build the service
```text
mvn clean package
```

### How to run the service
#### Local Environment Profile

```text
java -jar target/reservations-service-0.0.1-RELEASE.jar
```

#### Production Environment Profile
```text
java -jar -Dspring.profiles.active=production -Djasypt.encryptor.password=production target/reservations-service-0.0.1-RELEASE.jar
```

### How to call this service

| HTTP METHOD  | URL                                                   | 
| ------------ | ----------------------------------------------------- | 
| GET          | http://localhost:8080/reservations   | 
 

**Service Response:**
```javascript
[
    {
        "id": 1,
        "name": "Reservation No. 0",
        "time": "2020-09-05T20:32:01.811"
    },
    {
        "id": 2,
        "name": "Reservation No. 1",
        "time": "2020-09-06T20:32:01.922"
    },
    {
        "id": 3,
        "name": "Reservation No. 2",
        "time": "2020-09-07T20:32:01.923"
    },
    {
        "id": 4,
        "name": "Reservation No. 3",
        "time": "2020-09-08T20:32:01.925"
    },
    {
        "id": 5,
        "name": "Reservation No. 4",
        "time": "2020-09-09T20:32:01.926"
    },
    {
        "id": 6,
        "name": "Reservation No. 5",
        "time": "2020-09-10T20:32:01.927"
    }
]
```

### View Service Documentation
```text
http://localhost:8080/swagger-ui.html
```
