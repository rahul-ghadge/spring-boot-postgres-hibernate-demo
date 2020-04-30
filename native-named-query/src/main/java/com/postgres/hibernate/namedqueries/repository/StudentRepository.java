package com.postgres.hibernate.namedqueries.repository;

import com.postgres.hibernate.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Integer> {

    @Query(value = "SELECT * FROM student_details s WHERE s.student_id = ?1", nativeQuery = true)
    List<Student> getNativeStudentByIdByIndex(int id);


    @Query(value = "SELECT s FROM Student s")
    List<Student> getAllStudentByHQL();


    @Query("SELECT s FROM Student s WHERE s.firstName = :firstName and s.lastName = :lastName")
    Student getStudentByFirstNameAndLastName(String firstName, String lastName);



}
