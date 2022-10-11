# SpringBootCrudOperations
This small project is a walkthrough aimed at learning basic API CRUD Operations.


## CRUD OPERATIONS
  These operations serve as the basic functions of persistent storage.
  <blockquote>
  <p>C -Create -> POST</p>
   <p>R - Read -> GET</p>
  <p> U - Update -> PUT</p>
  <p> D - DELETE -> DELETE</p>
  </blockquote>
  
## Layers Implemeted
  - Controller
    - Serves the Rest endPoints
  - Service Layer
    - Contains the Business Logic
  - Access layer
    -Allows access to the database.
    

## Packaging
  Run maven clean</ br>
  Run maven install, which:</ br>
    validates
    compiles
    tests
    packages
    verifies
  
## Running the jar file
  <code>java -jar jarname.jar --server.root=8081</code>
  This will work iff there exists a server running as per configurations specified in the application.properties file.
  

    
## Concepts Learnt
  * Dependency Injection
  * CRUD Operations in SpringBoot
  * Database Integration with JPA -> (MYSQL)
  * Packaging api
  * Running your api on multiple instances



References: [amigoscode YT](https://www.youtube.com/watch?v=9SGDpanrc8U)
