package com.lms.www.springboot.service;

import com.lms.www.springboot.model.adminFeature.*;
import com.lms.www.springboot.model.user.UserLoginRequestDTO;
import com.lms.www.springboot.model.user.UserLoginResponseDTO;
import com.lms.www.springboot.model.user.UserModifyRequestDTO;

public interface CommonService {
    UserLoginResponseDTO userLogin(UserLoginRequestDTO userLoginRequestDTO);

    void userModify(Long num, UserModifyRequestDTO userModifyRequestDTO);

    void adminStudentAdd(StudentAddRequestDTO studentAddRequestDTO);

    StudentSearchResponseDTO adminStudentSearch(StudentSearchRequestDTO studentSearchRequestDTO);

    void adminProfessorAdd(ProfessorAddRequestDTO professorAddRequestDTO);

    ProfessorSearchResponseDTO adminProfessorSearch(ProfessorSearchRequestDTO professorSearchRequestDTO);
}
