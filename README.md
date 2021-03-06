# Auto & General test API

This application is to implement CRUD API with technologies like Spring Boot, Spring Data JPA, MySQL, JUnit, etc.

## Requirements
Java - 1.8.x

MySQL - 5.x.x

Maven - 3.x.x

## How to Run 

1. Clone the application
```
   git clone
```
2. Create MySQL database

3. Change MySQL username and password 

   - Open the file ```src/main/resources/application.properties```

   - Change ```spring.datasource.username``` and ```spring.datasource.password``` as per your MySQL settings.

4. Build and run the application using Maven, execute the following commands.
```
   mvn package
   java -jar target/autogeneral-api-0.0.1.jar
```

## REST API Overview
```
  GET /tasks/validateBrackets
```
  Check if brackets in a string are balanced. For example, the input bracket strings "()" "{{}} "{([])}" are balanced while "(({{" "[((]" "{}}}}" are not balanced. Eg: GET http://localhost:8080/tasks/validateBrackets?input=(){}[] 
```
  POST /todo
```
  Create a Todo item and ***Body*** is required. 
```
  GET /todo/{id} 
```
  Retrieve a specific Todo item by id. Eg: GET http://localhost:8080/todo/1
```
  PATCH /todo/{id} 
```
  Update a Todo item and ***Body*** is required. 
  
### Response with status code and Json message

  - **Sucess:** status code 200 and Json message
  - **Not Found:** status code 400 and Json message
  - **Validation Error:** status code 404 and Json message 

  These REST APIs can be tested with postman or any other REST API client.
