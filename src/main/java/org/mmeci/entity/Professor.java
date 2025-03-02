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
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;

    private String lastName;

    private String email;

    private String password;

    public Professor(String name, String lastName, String email, String password) {
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }

    @OneToMany(mappedBy = "professor")
    private List<Course> courses;
}
