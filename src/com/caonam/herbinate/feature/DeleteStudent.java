package com.caonam.herbinate.feature;

import com.caonam.herbinate.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.sql.Struct;

public class DeleteStudent {
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
        try {
            session.beginTransaction();

            int theId = 1;

            Student tempStudent = session.get(Student.class, theId);
            System.out.println("Student on id = " + theId + " - " + tempStudent);

            session.delete(tempStudent);

            session.getTransaction().commit();

        } finally {
            session.close();

            factory.close();
        }
    }
}
