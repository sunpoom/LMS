package com.lms.www.springboot.model.adminFeature;

import com.lms.www.springboot.domain.student.entity.Student;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class StudentSearchResponseDTO {
    private String name;
    private String student_id;
    private int year;
    private String major;
    private String registrationDate;

    public StudentSearchResponseDTO(Student student) {
        this.name = student.getName();
        this.student_id = student.getStudent_id();
        this.year = student.getYear();
        this.major = student.getMajor();
        this.registrationDate = student.getRegistration_date();
    }
}
