# eager-lazy-demo

**Spring boot hibernate postgreSql tutorial with JPA and EntityManager** - 
Here we will look into hibernate eager and lazy loading to fetch records from postgreSql database.  
While starting application it will check tables are exists, if not hibernate will create tables,
then as per functionality checking is there any record present in **`owner_details`** table, 
if not we are adding dummy **Owner** records with **Vehicle** details list and **Keys** details list.    

- Hibernate related configuration is under **`application.properties`** file.
- Reading above properties in **`com.postgres.hibernate.eagerlazy.config.HibernateConfig.java`** class.
- Find criteria related queries under **`com.postgres.hibernate.eagerlazy.dao.impl.OwnerVehicleDAOImpl.java`** class.


#### Relations
OwnerEntity   &nbsp;&nbsp;&nbsp;&nbsp;   **One-to-many**   &nbsp;&nbsp;&nbsp;&nbsp;   VehicleEntity   &nbsp;&nbsp;&nbsp;&nbsp;                               fetch = FetchType.LAZY   
OwnerEntity   &nbsp;&nbsp;&nbsp;&nbsp;   **One-to-many**   &nbsp;&nbsp;&nbsp;&nbsp;   KeyEntity       &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; fetch = FetchType.EAGER   


## Prerequisites 
- Java (Java 8)
- [Spring Boot](https://spring.io/projects/spring-boot)
- Hibernate
- [PostgreSQL](https://www.postgresql.org/docs/)
- [Maven](https://maven.apache.org/guides/index.html)


### Tools
- Eclipse or IntelliJ IDEA (or any preferred IDE) with embedded Gradle
- Maven (version >= 3.6.0)
- pgAdmin 4
- Postman (or any RESTful API testing tool)


###  Build and Run application
_GOTO >_ **~/absolute-path-to-directory/spring-boot-postgres-hibernate-demo/eager-lazy-demo**  
and try below command in terminal
> **```mvn spring-boot:run```** it will run application as spring boot application

or
> **```mvn clean install```** it will build application and create **jar** file under target directory 

Run jar file from below path with given command
> **```java -jar ~/path-to-<eager-lazy-demo>/target/eager-lazy-demo-0.0.1-SNAPSHOT.jar```**

Or run main method from `EagerLazyApp.java` as spring boot application.


### API End Points

> http://localhost:8080 - Get all students 


> http://localhost:8080/lazy-loading - Get records with **Lazy loading** (check logs)  


> http://localhost:8080/eager-loading -  Get records with **Eager loading** (check logs)

