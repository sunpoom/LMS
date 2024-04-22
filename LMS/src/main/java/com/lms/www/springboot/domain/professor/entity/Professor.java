package com.lms.www.springboot.domain.professor.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Entity
public class Professor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long professor_num;
    private String professor_id;
    private String name;
    private String email;
    private String password;
    private String major;
    private String sub_major;
    private String registration_date;
    private String role;

    @Builder
    public Professor(Long professor_num, String professor_id, String name, String email, String password, String major, String sub_major, String registration_date, String role) {
        this.professor_num = professor_num;
        this.professor_id = professor_id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.major = major;
        this.sub_major = sub_major;
        this.registration_date = registration_date;
        this.role = role;
    }
}
