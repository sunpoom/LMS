package com.lms.www.springboot.model.adminFeature;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class StudentSearchRequestDTO {
    private String name;
    private String student_id;

    @Builder
    public StudentSearchRequestDTO(String name, String student_id) {
        this.name = name;
        this.student_id = student_id;
    }
}
