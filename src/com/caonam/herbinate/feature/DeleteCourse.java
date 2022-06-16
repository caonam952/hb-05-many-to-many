package com.caonam.herbinate.feature;

import com.caonam.herbinate.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteCourse {
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

            int theId = 10;

            Course tempCourse = session.get(Course.class, theId);
            System.out.println("Course on id = " + theId + " - " + tempCourse);

            session.delete(tempCourse);

            session.getTransaction().commit();

        } finally {
            session.close();

            factory.close();
        }
    }
}
