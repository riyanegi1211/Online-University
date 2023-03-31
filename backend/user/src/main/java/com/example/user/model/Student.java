package com.example.user.model;
import java.io.Serializable;
import java.util.HashSet;

import com.example.user.model.User;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "student")
@PrimaryKeyJoinColumn(name = "user_id")
@NoArgsConstructor
@Getter
@Setter
public class Student extends User implements Serializable {

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Builder(builderMethodName = "studentBuilder")
    public Student(Long id, String username, String password, Role role, String firstName, String lastName) {
        super(id, username, password, role);
        this.firstName = firstName;
        this.lastName = lastName;
    }

}