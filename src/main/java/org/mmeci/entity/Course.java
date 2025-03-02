package org.mmeci.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity(name = "courses")
@Data
@NoArgsConstructor
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "professor_id")
    private Professor professor;

    @OneToMany(mappedBy = "course")
    private List<Grade> grades;

    @OneToMany(mappedBy = "course" , fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<StudentCourse> studentCourses;



}
