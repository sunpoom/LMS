package com.lms.www.springboot.model.user;

import com.lms.www.springboot.domain.admin.entity.Admin;
import com.lms.www.springboot.domain.professor.entity.Professor;
import com.lms.www.springboot.domain.student.entity.Student;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserLoginResponseDTO {
    private Long num;
    private String id;
    private String name;
    private String email;
    private String password;
    private String registration_date;
    private String role;

    ////////////////////////
    private String major;
    private String sub_major;
    //////////////////////////

    private int year;


    public UserLoginResponseDTO(Admin entity) {
        this.num = entity.getAdmin_num();
        this.id = entity.getAdmin_id();
        this.name = entity.getName();
        this.email = entity.getEmail();
        this.password = entity.getPassword();
        this.registration_date = entity.getRegistration_date();
        this.role = entity.getRole();
    }

    public UserLoginResponseDTO(Professor entity) {
        this.num = entity.getProfessor_num();
        this.id = entity.getProfessor_id();
        this.name = entity.getName();
        this.email = entity.getEmail();
        this.password = entity.getPassword();
        this.registration_date = entity.getRegistration_date();
        this.role = entity.getRole();
        this.major = entity.getMajor();
        this.sub_major = entity.getSub_major();
    }

    public UserLoginResponseDTO(Student entity) {
        this.num = entity.getStudent_num();
        this.id = entity.getStudent_id();
        this.name = entity.getName();
        this.email = entity.getEmail();
        this.password = entity.getPassword();
        this.registration_date = entity.getRegistration_date();
        this.role = entity.getRole();
        this.year = entity.getYear();
        this.sub_major=entity.getSub_major();
    }
}
