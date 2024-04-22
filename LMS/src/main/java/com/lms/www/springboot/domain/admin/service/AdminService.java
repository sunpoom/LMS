package com.lms.www.springboot.domain.admin.service;

import com.lms.www.springboot.model.user.UserLoginRequestDTO;
import com.lms.www.springboot.model.user.UserLoginResponseDTO;
import com.lms.www.springboot.model.user.UserModifyRequestDTO;

public interface AdminService {
    UserLoginResponseDTO findByIdAndPassword(UserLoginRequestDTO userLoginRequestDTO);

    void userModify(Long num, UserModifyRequestDTO userModifyRequestDTO);
}
