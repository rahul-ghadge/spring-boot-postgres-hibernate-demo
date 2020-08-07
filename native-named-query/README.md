# native-named-query

**Spring boot hibernate postgreSql tutorial with JPA and EntityManager** - 
Here we will see hibernate native named queries to fetch records from postgreSql database.  
While starting application it will check tables are exists. If not hibernate will create tables,
then as per functionality checking is there any record present in **`student_details`** table, if not we are adding dummy records in it.    

- Hibernate related configuration is under **`application.properties`** file.
- Reading above properties in **`com.postgres.hibernate.criteria.config.HibernateConfig.java`** class.
- Find **Named queries** under **`com.postgres.hibernate.criteria.dao.impl.StudentDAOImpl.java`** class.  
  All queries are placed under **`com.postgres.hibernate.models.utils.QueryUtils.java`** class and imported via **`entities`** module.
- **`JPA HQL queries`** are under **`com.postgres.hibernate.namedqueries.repository.StudentRepository.java`** class.


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


### Build and Run application
_GOTO >_ **~/absolute-path-to-directory/spring-boot-postgres-hibernate-demo/native-named-query**  
and try below command in terminal
> **```mvn spring-boot:run```** it will run application as spring boot application

or
> **```mvn clean install```** it will build application and create **jar** file under target directory 

Run jar file from below path with given command
> **```java -jar ~/path-to-<native-named-query>/target/native-named-query-0.0.1-SNAPSHOT.jar```**

or
> run main method from ```NativeNamedQueriesApp.java``` as spring boot application.


### API End Points

> http://localhost:8080 - Get all students


> http://localhost:8080/get-one - Get one record **(Check logs)** 


> http://localhost:8080/get-by-id - Get one record **(Check logs)**


> http://localhost:8080/get-jpa-queries - Get records by JPA HQL queries **(Check logs)**
