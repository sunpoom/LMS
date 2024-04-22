package com.lms.www.springboot.domain.student.service;


import com.lms.www.springboot.model.user.UserLoginRequestDTO;
import com.lms.www.springboot.model.user.UserLoginResponseDTO;

public interface StudentService {

    UserLoginResponseDTO findByIdAndPassword(UserLoginRequestDTO userLoginRequestDTO);
}
