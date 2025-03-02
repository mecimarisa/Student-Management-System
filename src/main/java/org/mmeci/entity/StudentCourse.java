package org.mmeci.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity(name = "student_course")
@Data
public class StudentCourse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "student_id")
    @ToString.Exclude
    private Student student;

    @ManyToOne
    @JoinColumn(name = "course_id")
    @ToString.Exclude
    private Course course;



}
