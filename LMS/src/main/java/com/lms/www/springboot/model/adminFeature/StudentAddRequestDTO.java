package com.lms.www.springboot.model.adminFeature;

import com.lms.www.springboot.domain.student.entity.Student;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class StudentAddRequestDTO {
    private String name;
    private String student_id;
    private String major;
    private String pw;

    @Builder
    public StudentAddRequestDTO(String name, String student_id, String major, String pw) {
        this.name = name;
        this.student_id = student_id;
        this.major = major;
        this.pw = pw;
    }

    public Student toEntity() {
        return Student.builder().name(name).student_id(student_id).major(major).password(pw).build();
    }
}
