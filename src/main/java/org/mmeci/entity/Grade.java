package org.mmeci.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "grades")
@Data
@NoArgsConstructor
public class Grade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long gradeId;

    private int grading;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    public Grade(int grading) {
        this.grading = grading;
    }
}
