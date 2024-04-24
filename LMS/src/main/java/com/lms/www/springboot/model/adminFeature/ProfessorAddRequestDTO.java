package com.lms.www.springboot.model.adminFeature;

import com.lms.www.springboot.domain.professor.entity.Professor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class ProfessorAddRequestDTO {
    private String name;
    private String professor_id;
    private String major;
    private String pw;

    @Builder
    public ProfessorAddRequestDTO(String name, String professor_id, String major, String pw) {
        this.name = name;
        this.professor_id = professor_id;
        this.major = major;
        this.pw = pw;
    }

    public Professor toEntity() {
        return Professor.builder().name(name).professor_id(professor_id).major(major).password(pw).build();
    }
}
