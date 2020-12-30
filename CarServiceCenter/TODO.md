# CAR SERVICE CENTER MANAGEMENT
## Purpose: Store and manage appointments for a car service center

### Requirements:
- Create new appointments
- Persist appointments in a data store
- Delete appointments
- Update appointment status
- Retrieve specific appointment
- Return all appointments in a date range sorted by price
- Appointment scheduler function to create new appointments at random intervals


### TODO:
- Create appointment class: must include a price, status, date (scheduled date? date appointment was made? date completed?). Must likely include: car details, customer details, description.
- Link to SQL appointment database
- Webpage to display database entries
- Add appointment form
- edit appointment form
- delete appointment option (cancel appointment)
- change status to completed option


### Minimum Viable Product Steps:
1. Connects to a database, and lists appointments that can be manually imported into the SQL database through the DBMS
2. Can import to SQL database from web app
3. Can edit and delete appointments
4. Retrieve appointments in date range by price through webpage form
5. Add Unit Testing framework e.g. JUnit
6. Automated appointment addition function
7. Figure out Docker/ Kubernetes
8. Figure out CI/CD Orchestration
9. Expand appointment class with customer/ car classes and relevant DB tables
10. If car or customer is new, add them to the appropriate DB table

