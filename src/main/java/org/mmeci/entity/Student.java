package org.mmeci.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Set;

@Entity(name = "students")
@Data
@NoArgsConstructor
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String lastName;

    private int yearOfStudy;


    @OneToMany(mappedBy = "student")
    private List<Grade> grades;

    public Student(String name, String lastName ,int yearOfStudy) {
        this.name = name;
        this.lastName = lastName;
        this.yearOfStudy = yearOfStudy;

    }
}
