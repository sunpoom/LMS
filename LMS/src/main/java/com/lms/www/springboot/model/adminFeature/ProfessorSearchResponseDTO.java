package com.lms.www.springboot.model.adminFeature;

import com.lms.www.springboot.domain.professor.entity.Professor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class ProfessorSearchResponseDTO {
    private String name;
    private String professor_id;
    private String major;
    private String registrationDate;

    public ProfessorSearchResponseDTO(Professor professor) {
        this.name = professor.getName();
        this.professor_id = professor.getProfessor_id();
        this.major = professor.getMajor();
        this.registrationDate = professor.getRegistration_date();
    }
}
