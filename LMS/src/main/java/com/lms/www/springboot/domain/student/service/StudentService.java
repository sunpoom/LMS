package com.lms.www.springboot.domain.student.service;


import com.lms.www.springboot.model.adminFeature.StudentAddRequestDTO;
import com.lms.www.springboot.model.adminFeature.StudentSearchRequestDTO;
import com.lms.www.springboot.model.adminFeature.StudentSearchResponseDTO;
import com.lms.www.springboot.model.user.UserLoginRequestDTO;
import com.lms.www.springboot.model.user.UserLoginResponseDTO;

public interface StudentService {

    UserLoginResponseDTO findByIdAndPassword(UserLoginRequestDTO userLoginRequestDTO);

    void adminStudentAdd(StudentAddRequestDTO studentAddRequestDTO);

    StudentSearchResponseDTO adminStudentSearch(StudentSearchRequestDTO studentSearchRequestDTO);
}
