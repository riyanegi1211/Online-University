package com.example.user.model;

// import jakarta.annotation.Generated;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "calender")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class CalenderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long eventId;

    @Column(name = "user_id")
    long userId;

    @Column(name= "start_date")
    String startDate;

    @Column(name = "end_date")
    String endDate;

    @Column(name = "task")
    String task;
}
