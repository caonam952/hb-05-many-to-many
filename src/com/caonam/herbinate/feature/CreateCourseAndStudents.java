package com.caonam.herbinate.feature;

import com.caonam.herbinate.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateCourseAndStudents {
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

            Course tempCourse = new Course("ISO");
            System.out.println("Save the course: " + tempCourse);
            session.save(tempCourse);

            Student tempStudent = new Student("Nam", "Cao", "@gmail.com");
            Student tempStudent2 = new Student("Ha", "Cao", "@gmail.com");

            tempCourse.addStudent(tempStudent);
            tempCourse.addStudent(tempStudent2);

            System.out.println("Saving Students!!");
            session.save(tempStudent);
            session.save(tempStudent2);
            System.out.println("Saved Student: " + tempCourse.getStudents());

            session.getTransaction().commit();

        }finally {
            session.close();

            factory.close();
        }
    }
}
