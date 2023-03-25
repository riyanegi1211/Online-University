package com.example.demo.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "students")
@PrimaryKeyJoinColumn(name = "user_id")
@NoArgsConstructor
@Getter
@Setter
public class Student extends User implements Serializable {

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    private Set<StudentCourseData> studentCourseData = new HashSet<>();

    @Builder(builderMethodName = "studentBuilder")
    public Student(Long id, String username, String password, Role role, String firstName, String lastName) {
        super(id, username, password, role);
        this.firstName = firstName;
        this.lastName = lastName;
    }

}