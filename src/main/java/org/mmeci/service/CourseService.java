package org.mmeci.service;

import jakarta.persistence.EntityManager;
import org.mmeci.entity.Course;
import org.mmeci.entity.Student;
import org.mmeci.repository.CourseRepository;
import org.mmeci.repository.StudentCourseRepository;
import org.mmeci.repository.StudentRepository;  // Importoni StudentRepository

import java.util.List;

public class CourseService {

    private final CourseRepository courseRepository;



    public CourseService(EntityManager entityManager) {
        this.courseRepository = new CourseRepository(entityManager);
    }

    public void addCourse(String name) {
        Course course = new Course(name);
        courseRepository.addCourse(course);
    }

    public Course getCourseById(Long id) {
        return courseRepository.getCourseById(id);
    }

    public Course getCourseByName(String name) {
        return courseRepository.getCourseByName(name);
    }

    public List<Course> getAllCourses() {
        return courseRepository.getAllCourses();
    }

    public void removeCourseById(Long id) {
        courseRepository.removeCourseById(id);
    }


    public boolean assignStudentToCourse(Student student, Course course) {
        return StudentCourseRepository.assignStudentToMovie(movie);
    }
}
