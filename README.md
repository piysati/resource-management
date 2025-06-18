Benchmark Assessment: 

1. Create a spring webservice application on start.spring.io(10 min) 
      Rest Services 
      Validations and Auditing 
      Mysql Database 
      Any other program structures you may need 

2. For the below table structure create JPA entities and repository ( 20 min ) 

employees                             projects 
+---------------+---------+           +---------------+---------+ 
| id            | int     |<----+  +->| id            | int     | 
| first_name    | varchar |     |  |  | title         | varchar | 
| last_name     | varchar |     |  |  | start_date    | date    | 
| salary        | int     |     |  |  | end_date      | date    | 
| department_id | int     |--+  |  |  | budget        | int     | 
+---------------+---------+  |  |  |  +---------------+---------+ 
                             |  |  | 
departments                  |  |  |  employees_projects 
+---------------+---------+  |  |  |  +---------------+---------+ 
| id            | int     |<-+  |  +--| project_id    | int     | 
| name          | varchar |     +-----| employee_id   | int     | 
+---------------+---------+           +---------------+---------+ 


3. Create a department CRUD service (20 min ) 
4. Create an Employee Service CRUD service. Only the department should be assigned, with no projects assigned. Ensure proper validations and integrity
5. Design and create REST services for assigning projects to Employees (30 min) 
6. Add Validation to the first_name and salary  fields in the Employee POJO. first_name should not be empty and salary should be a non-negative number (2 decimals allowed). Do later. 
7. Add a Global Exception handler to the REST application. It should handle the above exceptions as well as any generic exception thrown. (20 mins) 
