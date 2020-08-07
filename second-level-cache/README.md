# second-level-cache

**Spring boot hibernate postgreSql tutorial with JPA and EntityManager** - 
Here we will look into hibernate Second Level Cache while fetching records from postgreSql database.  
`Second Level Cache is configurable and which is disabled by-default, we can` **`ENABLE`** `it with configuration`.  
While starting application it will check tables are exists, if not hibernate will create tables,
then as per functionality checking is there any record present in **`user_details`** table, 
if not we are adding dummy **user_details** records.    

- Hibernate related configuration is under **`application.properties`** file.
- Reading above properties in **`com.postgres.hibernate.secondlevelcache.config.HibernateConfig.java`** class.
- Find **First Level Cache** related functionality under **`com.postgres.hibernate.secondlevelcache.dao.impl.UserEntityDAOImpl.java`** class.
- To **ENABLE** second level cache, add **`ehcache`** dependency in `pom.xml` file.
- Add `@Cacheable` annotation on **UserEntity** entity class with `@Cache` with **Cache Strategy**.  
- For fetching record using query, need to enable Cache with hint `setHint("org.hibernate.cacheable", true)` for createQuery() method.


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
_GOTO >_ **~/absolute-path-to-directory/spring-boot-postgres-hibernate-demo/second-level-cache**  
and try below command in terminal
> **```mvn spring-boot:run```** it will run application as spring boot application

or
> **```mvn clean install```** it will build application and create **jar** file under target directory 

Run jar file from below path with given command
> **```java -jar ~/path-to-<second-level-cache>/target/second-level-cache-0.0.1-SNAPSHOT.jar```**

Or 
> run main method from `SecondLevelCacheApp.java` as spring boot application.


### API End Points

> http://localhost:8080 - Get all User details 


> http://localhost:8080/save-random-user - Save User details in DB (check logs)  


> http://localhost:8080/jpa-cache - Get User details record from the Cache with JPA (check logs)


> http://localhost:8080/query-cache - Remove all Owner records from the Cache with query (check logs)
