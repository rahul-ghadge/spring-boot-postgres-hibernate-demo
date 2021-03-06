# first-level-cache

**Spring boot hibernate postgreSql tutorial with JPA and EntityManager** - 
Here we will look into hibernate many to many mapping with WhatsAppGroup to WhatsAppGroupAdmin.  
While starting application it will check tables are exists, if not hibernate will create tables,
then as per functionality checking is there any record present in **`whatsapp_group`** table, 
if not we are adding dummy **whatsapp_group** records with **whatsapp_group_admin**.    

- Hibernate related configuration is under **`application.properties`** file.
- Reading above properties in **`com.postgres.hibernate.manytomany.config.HibernateConfig.java`** class.
- Find **Many To Many** related functionality under **`com.postgres.hibernate.manytomany.dao.impl.WhatsAppGroupDAOImpl.java`** class.


#### Relations
WhatsAppGroup   &nbsp;&nbsp;&nbsp;&nbsp;   **many-to-many**   &nbsp;&nbsp;&nbsp;&nbsp;   WhatsAppGroupAdmin   


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
_GOTO >_ **~/absolute-path-to-directory/spring-boot-postgres-hibernate-demo/many-to-many**  
and try below command in terminal
> **```mvn spring-boot:run```** it will run application as spring boot application

or
> **```mvn clean install```** it will build application and create **jar** file under target directory 

Run jar file from below path with given command
> **```java -jar ~/path-to-<many-to-many>/target/many-to-many-0.0.1-SNAPSHOT.jar```**

Or
> run main method from `ManyToManyApp.java` as spring boot application.


### API End Points

> http://localhost:8080 - Get all Whatsapp groups with their respective admin details 


> http://localhost:8080/save-whatsapp-group - Save hardcoded Whatsapp groups with their respective admin details manually  


> http://localhost:8080/get-by-id - Get all Whatsapp groups with their respective admin details by ID
