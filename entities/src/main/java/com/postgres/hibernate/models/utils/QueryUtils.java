package com.postgres.hibernate.models.utils;

public class QueryUtils {

    private QueryUtils() {}

    public static final String STUDENT_BY_ID_IDENTIFIER = "student.byId";
    public static final String STUDENT_BY_ID = "from Student s where s.studentId = :id";


    public static final String STUDENT_BY_NAME_IDENTIFIER = "student.byName";
    public static final String STUDENT_BY_NAME = "from Student s where s.firstName = :firstName";


    public static final String STUDENT_BY_LAST_NAME_IDENTIFIER = "student.byLastName";
    public static final String STUDENT_BY_LAST_NAME = "select * from student_details s where s.last_name = ?";

}
