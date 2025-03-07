package org.mmeci.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity(name = "professors")
@Data
@NoArgsConstructor
public class Professor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    private String lastName;

    private String specialization;

    public Professor(String name, String lastName , String specialization) {
        this.name = name;
        this.lastName = lastName;
        this.specialization = specialization;

    }

    @OneToMany(mappedBy = "professor")
    private List<Course> courses;
}
