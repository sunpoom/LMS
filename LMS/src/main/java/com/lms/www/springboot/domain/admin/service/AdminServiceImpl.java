package com.lms.www.springboot.domain.admin.service;

import com.lms.www.springboot.domain.admin.entity.Admin;
import com.lms.www.springboot.domain.admin.repository.AdminRepository;
import com.lms.www.springboot.exception.EntityNotFoundException;
import com.lms.www.springboot.model.user.UserLoginRequestDTO;
import com.lms.www.springboot.model.user.UserLoginResponseDTO;
import com.lms.www.springboot.model.user.UserModifyRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class AdminServiceImpl implements AdminService {

    private final AdminRepository adminRepository;

    @Override
    @Transactional
    public UserLoginResponseDTO findByIdAndPassword(UserLoginRequestDTO userLoginRequestDTO) {
        Admin admin = adminRepository.findByIdAndPassword(userLoginRequestDTO.getId(), userLoginRequestDTO.getPw());
        if (admin == null) {
            throw new EntityNotFoundException("해당아이디랑 비밀번호가 다릅니다");
        }
        return new UserLoginResponseDTO(admin);
    }

    @Override
    @Transactional
    public void userModify(Long num, UserModifyRequestDTO userModifyRequestDTO) {
        Admin admin = adminRepository.findById(num).orElseThrow(() -> new EntityNotFoundException("해당 아이디가 없습니다"));
        admin.modify(userModifyRequestDTO);
    }
}
