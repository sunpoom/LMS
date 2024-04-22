package com.lms.www.springboot.domain.student.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@NoArgsConstructor
@Getter
@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long student_num;
    private String student_id;
    private String name;
    private String email;
    private String password;
    private String registration_date;
    private int year;
    private String major;
    private String sub_major;
    private String role;

    @Builder
    public Student(Long student_num, String student_id, String name, String email, String password, String registration_date, int year, String major, String sub_major, String role) {
        this.student_num = student_num;
        this.student_id = student_id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.registration_date = registration_date;
        this.year = year;
        this.major = major;
        this.sub_major = sub_major;
        this.role = role;
    }
}
