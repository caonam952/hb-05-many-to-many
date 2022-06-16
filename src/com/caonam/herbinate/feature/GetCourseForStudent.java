package com.caonam.herbinate.feature;

import com.caonam.herbinate.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class GetCourseForStudent {
    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Review.class)
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();
        try{
            session.beginTransaction();

            int theId = 2;

            System.out.println("Student on id = " + theId );
            Student tempStudent = session.get(Student.class, theId);
            System.out.println("Loaded Student: " + tempStudent + "\nWith Course: " + tempStudent.getCourses());

            session.getTransaction().commit();

        }finally {
            session.close();

            factory.close();
        }
    }
}
