package com.lms.www.springboot.domain.professor.service;


import com.lms.www.springboot.model.user.UserLoginRequestDTO;
import com.lms.www.springboot.model.user.UserLoginResponseDTO;

public interface ProfessorService {

    UserLoginResponseDTO findByIdAndPassword(UserLoginRequestDTO userLoginRequestDTO);
}
