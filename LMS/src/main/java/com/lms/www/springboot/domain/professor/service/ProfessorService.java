package com.lms.www.springboot.domain.professor.service;


import com.lms.www.springboot.model.adminFeature.ProfessorAddRequestDTO;
import com.lms.www.springboot.model.adminFeature.ProfessorSearchRequestDTO;
import com.lms.www.springboot.model.adminFeature.ProfessorSearchResponseDTO;
import com.lms.www.springboot.model.user.UserLoginRequestDTO;
import com.lms.www.springboot.model.user.UserLoginResponseDTO;

public interface ProfessorService {

    UserLoginResponseDTO findByIdAndPassword(UserLoginRequestDTO userLoginRequestDTO);

    void adminProfessorAdd(ProfessorAddRequestDTO professorAddRequestDTO);

    ProfessorSearchResponseDTO adminProfessorSearch(ProfessorSearchRequestDTO professorSearchRequestDTO);
}
