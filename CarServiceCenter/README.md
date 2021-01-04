# CAR SERVICE CENTER MANAGEMENT REST API
## Purpose: Store and manage appointments for a car service center
- Delete appointments from the database
- Create new appointments 
- Update the status of an existing appointment
- Retrieve a specific appointment from the database.
- Retrieve all appointments that are scheduled between a date range and sorted by price.

## Solution
### Outline:
#### Data
The key Appointment entity:

```
Appointment : {
  id : Int,
  customer_name : String,
  customer_phone : String,
  car_description: String,
  plate_number : String,
  appt_description: String,
  status: String,
  price: Float,
  date_created: Date
},
```

#### Structure

```
CarServiceCenter/src/main/java
│   | CarServiceCenterApplication.java    
│
└─── controller
│   │   AppointmentController.java
│   
└─── domain
|    │   Appointment.java
|    |   Scheduler.java
│   
└─── repository
|    │   AppointmentRepository.java   
│   
└─── service
|    │   AppointmentService.java 
|
CarServiceCenter/src/main/resources   
│
└─── templates
   │   index.html
    |   addnew.html
    
```

### Tools and Frameworks
Built using Java Spring Boot framework due to the rapid prototyping nature and the inclusion of in-memory database options. Thymeleaf front end.

## How to run

### Git
Pull from:
`https://github.com/heathercraddock/car-service-center.git`

### Maven / Jar
`cd` into directory containing `pom.xml`.
`$ mvn clean package`
`$ java -jar target/CarServiceCenter-0.0.1-SNAPSHOT.jar `

### Docker
`cd` into directory containing `pom.xml`
With Docker running:
`$ docker build -t car-service-center .`
`$ docker run -p 8082:8082 heathercraddock/car-service-center:1.0`

### Access
`localhost:8082/`

## Technologies to Consider
- Language: Java
- Cmd Line Build: Maven
- Datastore: H2
- Docker/ Kubernetes: Docker
- Unit Testing Framework: JUnit (some)
~~-CI/CD Orchestration~~

## Discussion

**Random Scheduling of Appointments:** Comment out `@EnableScheduling` in `CarServiceCenterApplication.java` to prevent automatic generation of appointment entities. 

**Data Model:** Data model should ideally include additional entities, such as Car (Make, Model, Year, Vin, Color, etc.), Customer (First Name, Last Name, Contact Number, Cars, etc.), and Services (Service Type, Service Cost). Data model was simplified for initial implementation purposes.

**Security:** No security layer. Spring Boot has in-built security that can (and should) be added for identity verification before a user can access and adjust the data.

**Input Valid:** Needs to be added to the create appointment form in the form of: checking valid phone number, ensuring required fields are completed.

**Query Links:** UI link to find appointments in date range organized by price is currently preset (no dynamic redirection from index; likewise, redirectly to specific appointment id is specified in the url redirection link. This requires correction from the Thymeleaf front end.

**Unit Testing:** Some successful tests generated in JUnit, but the test cases need more work. Tests should at minimum cater to testing the CRUD operations on the database.

**CI/CD:** Missing.
