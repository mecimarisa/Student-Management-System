package org.mmeci.service;

import jakarta.persistence.EntityManager;
import org.mmeci.entity.Student;
import org.mmeci.repository.StudentRepository;

import java.util.List;

public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(EntityManager entityManager) {
        this.studentRepository = new StudentRepository(entityManager);
    }

    public void addStudent(String name, String lastName, int yearOfStudy) {
        Student student = new Student(name, lastName, yearOfStudy);
        studentRepository.addStudent(student);
    }

    public Student getStudentById(Long id) {
        Student student = studentRepository.getStudentById(id);
        if (student == null) {
            System.out.println("Student with ID " + id + " not found");
        }
        return student;
    }

    public Student getStudentByName(String name) {
        Student student = studentRepository.getStudentByName(name);
        if (student == null) {
            System.out.println("Student with name " + name + " not found");
        }
        return student;
    }

    public List<Student> getAllStudents() {
        return studentRepository.getAllStudents();
    }

    public void removeStudentById(Long id) {
        studentRepository.removeStudentById(id);
    }
}