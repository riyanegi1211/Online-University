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
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class NewStudent {

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "user_id")
    private Long id;

    @Column(name = "semester")
    private Long studentSemester;

    @Column(name = "branch")
    private String studentBranch;

    @Column(name= "student_id")
    private String studentId;

    @Override
    public String toString() {
        return "NewStudent [firstName=" + firstName + ", lastName=" + lastName + ", id=" + id + ", studentSemester="
                + studentSemester + ", studentBranch=" + studentBranch + ", studentId=" + studentId + "]";
    }


    

    // @Builder
    // public NewStudent(String firstName, String lastName) {
    //     //super(id, username, password, role);
    //     this.firstName = firstName;
    //     this.lastName = lastName;
    // }

}