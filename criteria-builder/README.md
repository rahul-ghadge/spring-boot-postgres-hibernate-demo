# citeria-builder

**Spring boot hibernate postgreSql tutorial with JPA and EntityManager** - 
Here we will cover hibernate criteria builder to fetch records from postgreSql database.  
While starting application it will check tables are exists. If not hibernate will create tables,
then as per functionality checking is there any record present in **`student_details`** table, if not we are adding dummy records in it.    

- Hibernate related configuration is under **`application.properties`** file.
- Reading above properties in **`com.postgres.hibernate.criteria.config.HibernateConfig.java`** class.
- Find criteria related queries under **`com.postgres.hibernate.criteria.dao.impl.StudentDAOImpl.java`** class.


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
_GOTO >_ **~/absolute-path-to-directory/spring-boot-postgres-hibernate-demo/criteria-builder**  
and try below command in terminal
> **```mvn spring-boot:run```** it will run application as spring boot application

or
> **```mvn clean install```** it will build application and create **jar** file under target directory 

Run jar file from below path with given command
> **```java -jar ~/path-to-<criteria-builder>/target/criteria-builder-0.0.1-SNAPSHOT.jar```**

Or run main method from `CriteriaBuilderApp.java` as spring boot application.


### API End Points

> Get all students - http://localhost:8080/


> Get one record - http://localhost:8080/get-one


> Get one record - http://localhost:8080/get-by-id

