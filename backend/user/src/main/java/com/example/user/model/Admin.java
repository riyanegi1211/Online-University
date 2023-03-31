package com.example.user.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
// import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "admin")
@PrimaryKeyJoinColumn(name = "user_id")
@NoArgsConstructor
@Getter
@Setter
public class Admin extends User implements Serializable{

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Builder(builderMethodName = "adminBuilder")
    public Admin(Long id, String username, String password, Role role, String firstName, String lastName) {
        super(id, username, password, role);
        this.firstName = firstName;
        this.lastName = lastName;
    }

}
