package org.mmeci.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import lombok.AllArgsConstructor;
import org.mmeci.entity.Course;

import java.util.List;

@AllArgsConstructor
public class CourseRepository {

    private EntityManager entityManager;

    public void addCourse(Course course) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.persist(course);
            transaction.commit();
            System.out.println("Course saved successfully!");
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        }
    }


    public Course getCourseById(Long id) {
        return entityManager.find(Course.class, id);
    }

    public Course getCourseByName(String name) {
        return entityManager.find(Course.class, name);
    }

    public List<Course> getAllCourses() {
        return entityManager.createQuery("from Course", Course.class).getResultList();
    }


    public void removeCourseById(Long id) {

        Course course = entityManager.find(Course.class, id);
        if (course == null) {
            System.out.println("Course not found");
            return;
        }

        EntityTransaction entityTransaction = entityManager.getTransaction();

        try {
            entityTransaction.begin();
            entityManager.remove(course);
            entityTransaction.commit();
            System.out.println("Course removed with id: " + id + " successfully");

        }catch (Exception e) {
            entityTransaction.rollback();
            e.printStackTrace();
        }
    }


    public EntityManager getEntityManager() {
            return entityManager;
    }
}
