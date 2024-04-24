package com.lms.www.springboot.model.adminFeature;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class ProfessorSearchRequestDTO {
    private String name;
    private String professor_id;

    @Builder
    public ProfessorSearchRequestDTO(String name, String professor_id) {
        this.name = name;
        this.professor_id = professor_id;
    }
}
