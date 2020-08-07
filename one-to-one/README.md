# one-to-many

**Spring boot hibernate postgreSql tutorial with JPA and EntityManager** - 
Here we will look into hibernate one to one mapping while fetching records from postgreSql database.  
While starting application it will check tables are exists, if not hibernate will create tables,
then as per functionality checking is there any record present in **`country`** table, 
if not we are adding dummy **country** records with unique **dial_in_details** details.  

- Hibernate related configuration is under **`application.properties`** file.
- Reading above properties in **`com.postgres.hibernate.onetoone.config.HibernateConfig.java`** class.
- Find **First Level Cache** related functionality under **`com.postgres.hibernate.onetoone.dao.impl.CountryDAOImpl.java`** class.


#### Relations
Country   &nbsp;&nbsp;&nbsp;&nbsp;   **one-to-one**   &nbsp;&nbsp;&nbsp;&nbsp;   DialInDetails   


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
_GOTO >_ **~/absolute-path-to-directory/spring-boot-postgres-hibernate-demo/one-to-one**  
and try below command in terminal
> **```mvn spring-boot:run```** it will run application as spring boot application

or
> **```mvn clean install```** it will build application and create **jar** file under target directory 

Run jar file from below path with given command
> **```java -jar ~/path-to-<one-to-one>/target/one-to-one-0.0.1-SNAPSHOT.jar```**

Or 
> run main method from `OneToOneApp.java` as spring boot application.


### API End Points

> http://localhost:8080 - Get all Country details with respective Dial-In Numbers 


> http://localhost:8080/get-one - Get one Country details with respective Dial-In Number  


> http://localhost:8080/get-by-id - Get one Country details with respective Dial-In Number by ID
