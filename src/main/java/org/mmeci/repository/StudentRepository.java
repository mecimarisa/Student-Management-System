package org.mmeci.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import org.mmeci.entity.Student;

import java.util.List;

public class StudentRepository {

    private final EntityManager entityManager;

    public StudentRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void addStudent(Student student) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.persist(student);
            transaction.commit();
            System.out.println("Student added successfully: " + student.getName());
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        }
    }

    public List<Student> getAllStudents() {
        return entityManager.createQuery("FROM Student ", Student.class).getResultList();
    }

    public Student getStudentById(Long id) {
        return entityManager.find(Student.class, id);
    }

    public Student getStudentByName(String name) {
        return entityManager.find(Student.class, name);
    }

    public void removeStudentById(Long id) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            Student student = entityManager.find(Student.class, id);
            if (student != null) {
                entityManager.remove(student);
                System.out.println("Student removed successfully: " + student.getName());
            } else {
                System.out.println("Student with ID " + id + " not found");
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            System.err.println("Failed to remove student: " + e.getMessage());
        }
    }
}