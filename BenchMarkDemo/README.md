#### \# Employee Project Management System



\## 📝 Project Overview



This is a Spring Boot RESTful web service application named \*\*Employee Project Management System\*\*, developed as part of a benchmark assessment. The application manages employees, departments, and projects with full CRUD operations, validations, and relational mappings using JPA and MySQL.







\## 🚀 Technologies Used



\- Java 21

\- Spring Boot

\- Spring Data JPA

\- Spring Web

\- Hibernate

\- MySQL Database

\- Maven

\- Postman (for testing)

\- H2 Console (optional for in-memory testing)







\## 🗂️ Database Schema



The application uses the following relational schema:



\### Tables:

\- \*\*employees\*\*: `id`, `first\_name`, `last\_name`, `salary`, `department\_id`

\- \*\*departments\*\*: `id`, `name`

\- \*\*projects\*\*: `id`, `title`, `start\_date`, `end\_date`, `budget`

\- \*\*employees\_projects\*\*: `employee\_id`, `project\_id` (join table for many-to-many relationship)







\## ✨ Features Implemented



1\. \*\*Department CRUD Service\*\*

&nbsp;  - Create, Read, Update, Delete departments

&nbsp;  - Validation: unique department name



2\. \*\*Employee CRUD Service\*\*

&nbsp;  - Create, Read, Update, Delete employees

&nbsp;  - Initially assigned only to a department (no projects)

&nbsp;  - Validation:

&nbsp;    - `first\_name` must not be empty

&nbsp;    - `salary` must be a non-negative number with up to 2 decimal places



3\. \*\*Project CRUD Service\*\*

&nbsp;  - Create, Read, Update, Delete projects

&nbsp;  - Validation: unique project title



4\. \*\*Project Assignment Service\*\*

&nbsp;  - Assign multiple projects to an employee

&nbsp;  - Remove a project from an employee

&nbsp;  - View all projects assigned to an employee



5\. \*\*Global Exception Handling\*\*

&nbsp;  - Handles validation errors, entity not found, and generic exceptions

&nbsp;  - Returns structured error responses with meaningful messages







\## ⚙️ Setup Instructions



1\. \*\*Clone the repository\*\*

&nbsp;  

&nbsp;  git clone https://github.com/your-username/employee-project-management.git

&nbsp;  cd employee-project-management

&nbsp;  

2\. \*\*Configure the MySQL Database\*\*

&nbsp;  - Create a database named **benchmark\_demo**

&nbsp;  - Update application.properties

&nbsp;	```

		*spring.datasource.url=jdbc:mysql://localhost:3306/benchmark\_demo*

		*spring.datasource.username=root*

		*spring.datasource.password=root*

		*spring.jpa.hibernate.ddl-auto=update*

&nbsp;	```



3\. \*\*Build and Run the applications\*\*

     *mvn clean install*

     *mvn spring-boot:run*









\## API endpoints

\*\*Department\*\*

POST  	 /department/ – Create department

GET    	 /department/{id} – Get department by ID

GET   	 /department/ – Get all departments

PUT 	 /department/{id} – Update department

DELETE   /department/{id} – Delete department



\*\*Employee\*\*

POST 	 /employees/ – Create employee

GET 	 /employees/{id} – Get employee by ID

GET 	 /employees/ – Get all employees

PUT 	 /employees/{id} – Update employee

DELETE 	 /employees/{id} – Delete employee



\*\*Project\*\*

POST 	 /project/ – Create project

GET 	 /project/{id} – Get project by ID

GET 	 /project/ – Get all projects

PUT 	 /project/{id} – Update project

DELETE 	 /project/{id} – Delete project



\*\*Project Assignment\*\*

POST 	 /employees/{id}/projects – Assign projects to employee

GET 	 /employees/{id}/projects – Get employee's projects

DELETE 	 /employees/{id}/projects/{projectId} – Remove project from employee









\## 📚 Learnings \& Highlights

Designed a modular Spring Boot application using layered architecture (Controller, Service, Repository).

Implemented JPA entity relationships including many-to-one and many-to-many.

Used DTOs for clean API contracts and data hiding.

Applied validation annotations for input integrity.

Built a global exception handler for consistent error responses.

Practiced RESTful API design and testing using Postman.

Gained hands-on experience with Spring Data JPA and Hibernate.





