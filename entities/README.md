# entities

**Spring boot hibernate postgreSql tutorial with JPA and EntityManager** - 
All Entity classes are placed in separate module under **entities** and this module is added in all other modules.  
This module is building first if calling build on any module where it is imported and then respective module will get build.  

> Here we are disable below autoconfiguration from **`com.postgres.hibernate.models.EntitiesApp.java`** class, 
otherwise it will look for JPA datasource related configuration
    - DataSourceAutoConfiguration.class
    - DataSourceTransactionManagerAutoConfiguration.class
    - HibernateJpaAutoConfiguration.class

#
#### Entity Relations
> Package **com.postgres.hibernate.models**

<!-- ******* 1 ********* -->
Country
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
**one-to-one**
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
DialInDetails
<!-- ******* 2 ********* -->
DialInDetails
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
**one-to-one**
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
Country
<!-- ******* 3 ********* -->
KeyEntity
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
**many-to-one**
&nbsp;&nbsp;&nbsp;&nbsp;
OwnerEntity
 <!-- ******* 4 ********* -->
OwnerEntity
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
**one-to-many**
&nbsp;&nbsp;&nbsp;&nbsp;
VehicleEntity
&nbsp;&nbsp;&nbsp;&nbsp;
fetch = FetchType.LAZY  
<!-- ******* 5 ********* -->
OwnerEntity
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
**one-to-many**
&nbsp;&nbsp;&nbsp;&nbsp;
KeyEntity
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
fetch = FetchType.EAGER  
<!-- ******* 6 ********* -->
Student  
<!-- ******* 7 ********* -->
UserEntity  
<!-- ******* 8 ********* -->
VehicleEntity
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
**many-to-one**
&nbsp;&nbsp;&nbsp;&nbsp;
OwnerEntity  
<!-- ******* 9 ********* -->
WhatsAppGroup
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
**many-to-many**
&nbsp;
WhatsAppGroupAdmin  
<!-- ******* 10 ********* -->
WhatsAppGroupAdmin
**many-to-many**
&nbsp;
WhatsAppGroup  


> Package **com.postgres.hibernate.models.utils**  
  class **`Utils.java`**

In this class all below queries are added as final static strings: 
   - _STUDENT_BY_ID_  
   - _STUDENT_BY_NAME_  
   - _STUDENT_BY_LAST_NAME_
     
## Prerequisites 
- Hibernate
- [PostgreSQL](https://www.postgresql.org/docs/)
- [Maven](https://maven.apache.org/guides/index.html)



