package com.lms.www.springboot.domain.admin.entity;

import com.lms.www.springboot.model.user.UserModifyRequestDTO;
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
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long admin_num;
    private String admin_id;
    private String name;
    private String email;
    private String password;
    private String registration_date;
    private String role;

    @Builder
    public Admin(Long admin_num, String admin_id, String name, String email, String password, String registration_date, String role) {
        this.admin_num = admin_num;
        this.admin_id = admin_id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.registration_date = registration_date;
        this.role = role;
    }

    public void modify(UserModifyRequestDTO userModifyRequestDTO) {
        this.admin_id= userModifyRequestDTO.getId();
        this.email= userModifyRequestDTO.getEmail();
        this.password= userModifyRequestDTO.getPw();
    }
}
