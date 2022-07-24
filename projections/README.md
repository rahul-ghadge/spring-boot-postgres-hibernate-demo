# projections

**Spring boot hibernate postgreSql tutorial with JPA and EntityManager** - 
Here we will see JPA projections to fetch selected column(s) data instead whole entitty from postgreSql database.  
While starting application it will check tables are exists. If not hibernate will create tables,
then as per functionality checking is there any record present in **`country`** table,
if not we are adding dummy **country** records with unique **dial_in_details** details.

- Hibernate related configuration is under **`application.properties`** file.
- Reading above properties in **`com.postgres.hibernate.projections.config.HibernateConfig.java`** class.
- Find **JPA projections** related functionality under **`com.postgres.hibernate.projections.repository.CountryRepository.java`** interface.


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


### Build and Run application
_GOTO >_ **~/absolute-path-to-directory/spring-boot-postgres-hibernate-demo/projections**  
and try below command in terminal
> **```mvn spring-boot:run```** it will run application as spring boot application

or
> **```mvn clean install```** it will build application and create **jar** file under target directory 

Run jar file from below path with given command
> **```java -jar ~/path-to-<projections>/target/projections-0.0.1-SNAPSHOT.jar```**

or
> run main method from ```ProjectionsApp.java``` as spring boot application.


### Code Snippets
1. #### Maven Dependencies
   Need to add below dependencies to enable H2 DB related config in **pom.xml**. **web**, **data-jpa** dependencies are inherited from parent 
   **pom.xml** file. **entities** dependency is used to reuse entities classes from different module. 
    ```
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>
   
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-data-jpa</artifactId>
    </dependency>
   
    <dependency>
        <groupId>org.postgresql</groupId>
        <artifactId>postgresql</artifactId>
        <scope>runtime</scope>
    </dependency>
   
    <dependency>
        <groupId>com.postgres.hibernate.models</groupId>
        <artifactId>entities</artifactId>
        <version>0.0.1-SNAPSHOT</version>
    </dependency>
   
    ```

2. #### Properties file
   Reading H2 DB related properties from **application.properties** file and configuring JPA connection factory for H2 database.

   **src/main/resources/application.properties**
     ```
   ## Spring DATASOURCE (DataSourceAutoConfiguration & DataSourceProperties)
   spring.datasource.url=jdbc:postgresql://localhost:5432/emp
   spring.datasource.username=postgres
   spring.datasource.password=root

   # The SQL dialect makes Hibernate generate better SQL for the chosen database
   spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect

   # Hibernate ddl auto (create, create-drop, validate, update)
   spring.jpa.hibernate.ddl-auto=update
    
   spring.jpa.properties.hibernate.show_sql=true
   spring.jpa.properties.hibernate.use_sql_comments=true
   spring.jpa.properties.hibernate.format_sql=true
     ```

3. #### Model class
   Below are the model classes which we will store in postres DB and perform fetch operations.  
   **Country.java**
    ```
    @Entity
    @Table
    public class Country {

       private static final long serialVersionUID = 1L;

       @Id
       @GeneratedValue(strategy = GenerationType.SEQUENCE)
       @Column(name = "country_Id", unique = true, nullable = false)
       private Integer id;

       @Column(name="country_name", unique = true, nullable = false)
       private String countryName;

       @Column(name="continent", nullable = false)
       private String continent;

       @OneToOne(cascade=CascadeType.ALL)
       @JoinColumn(name="dial_in_detail_id")
       private DialInDetails dialInDetails;
   
       // Default & parameterized Constructor, Getter, Setter and toString methods
    }
    ```

    **DialInDetails.java**
    ```
    @Entity
    @Table(name = "dial_in_details")
    public class DialInDetails {

       private static final long serialVersionUID = 1L;

       @Id
       @GeneratedValue(strategy = GenerationType.SEQUENCE)
       @Column(name = "dial_in_detail_Id", unique = true, nullable = false)
       private Integer id;

       @Column(name = "country_code", unique = true, nullable = false)
       private String countryCode;

       @Column(name = "country_dial_in_code", unique = true, nullable = false)
       private String countryDialInCode;

       @OneToOne(mappedBy="dialInDetails", cascade=CascadeType.ALL)
       private Country country;

       // Default & parameterized Constructor, Getter, Setter and toString methods
    }
    ```
   
    Here are some DTO classes which we are using for projections from entities module.
    **CountryDto.java**
    ```
    public class CountryDto {
    
       private Integer id;
       private String countryName;
       private String continent;  
 
       // Default & parameterized Constructor, Getter, Setter and toString methods
    }
    ```

    **CountryDto.java(interface with getters methods only)**
    ```
    public interface CountryView {

       Integer getId();
       String getCountryName() ;
       String getContinent();
    
    }
    ```

4. #### Get selected columns operations(projections) on Country

   In **ProjectionsController.java** class,
   we have exposed 4 endpoints for basic CRUD operations
   - GET Country details DTO with country name
   - GET Country details DTO in objects array as per continent
   - GET Country details DTO via constructor projection as per continent
   - GET Country details View DTO via interface projection as per continent
   ```
   @RestController
   @RequestMapping("/projections")
   public class ProjectionsController {

      @Autowired
      private CountryService countryService;

      @GetMapping("/country/dto/{countryName}")
      public ResponseEntity<?> findByCountryName(@PathVariable String countryName);

      @GetMapping("/country/object/array/{continent}")
      public ResponseEntity<?> getCountryDetails(@PathVariable String continent);

      @GetMapping("/country/constructor/{continent}")
      public ResponseEntity<?> findByContinentConstructor(@PathVariable String continent);

      @GetMapping("/country/view/interface/{continent}")
      public ResponseEntity<?> findViewByContinent(@PathVariable String continent);
   }
   ```

   In **CountryServiceImpl.java**, we are just going to call repository methods which will return us projection data.
   ```
   public Class CountryServiceImpl implements CountrySerice {
 
      List<Country> findAll();  // find all records from country table

      void save();              // save mock data to country table

      List<CountryDto> findByCountryName(String countryName);         // Get CountryDto for matcging country name

      List<Object[]> getCountryDetails(String continent);             // Get selected columns in object array as per continent 

      List<CountryDto> findByContinentConstructor(String continent);  // Get CountryDto via contructor binding for given continent 

      List<CountryView> findViewByContinent(String continent);        // Get CountryDto via interface methods binding for given continent 

   }
   ```

   In **CountryRepository.java**, we are extending `JpaRepository<Class, ID>` interface which enables CRUD related methods.<br>
   But here we are going to use projection operations via `@Query` annotation and return only selected properties/columns as per our need.
   And some Entity to DTO auto bindings also happening via JPA 

   ```
   public interface CountryRepository extends JpaRepository<Country, Integer> {

      List<CountryDto> findByCountryName(String countryName);

      @Query("SELECT c.id, c.countryName, c.continent FROM Country c WHERE c.continent = :continent")
      List<Object[]> getCountryDetails(String continent);

      @Query("SELECT new com.postgres.hibernate.models.dto.CountryDto(c.id, c.countryName, c.continent) FROM Country c WHERE c.continent = :continent")
      List<CountryDto> findByContinentConstructor(String continent);

      List<CountryView> findViewByContinent(String continent);
    
   }
   ```

### API End Points


  > GET http://localhost:8080/projections/country/dto/India

   **Response Body**
   ```
   [
     {
       "id": 21,
       "countryName": "India",
       "continent": "ASIA"
     }
   ]
   ```


  > GET http://localhost:8080/projections/country/object/array/ASIA

   **Response Body**
   ```
   [
     [
       21,
       "India",
       "ASIA"
     ],
     [
       23,
       "Japan",
       "ASIA"
     ]
   ]
   ```


  > GET http://localhost:8080/projections/country/constructor/ASIA

   **Response Body**
   ```
   [
     {
       "id": 21,
       "countryName": "India",
       "continent": "ASIA"
     },
     {
       "id": 23,
       "countryName": "Japan",
       "continent": "ASIA"
     }
   ]
   ```


  > GET http://localhost:8080/projections/country/view/interface/USA

   **Response Body**
   ```
   [
     {
       "id": 25,
       "countryName": "USA",
       "continent": "USA"
     }
   ]
   ```
