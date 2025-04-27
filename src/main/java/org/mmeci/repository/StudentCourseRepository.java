package org.mmeci.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.mmeci.entity.Course;
import org.mmeci.entity.Student;
import org.mmeci.entity.StudentCourse;

public class StudentCourseRepository {

    private final EntityManager entityManager;

    public StudentCourseRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public boolean assignStudentToCourse(Student student, Course course) {
        EntityTransaction entityTransaction = entityManager.getTransaction();

        try {

            entityTransaction.begin();
            StudentCourse studentCourse = new StudentCourse();
            studentCourse.setStudent(student);
            studentCourse.setCourse(course);
            entityManager.persist(studentCourse);
            entityTransaction.commit();
            return true;


        }catch (Exception e) {
            entityTransaction.rollback();
            e.printStackTrace();
            return false;
        }
    }
}
