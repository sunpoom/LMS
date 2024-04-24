package com.lms.www.springboot.controller;

import com.lms.www.springboot.model.user.UserLoginRequestDTO;
import com.lms.www.springboot.model.user.UserLoginResponseDTO;
import com.lms.www.springboot.model.user.UserModifyRequestDTO;
import com.lms.www.springboot.service.CommonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@RestController
public class UserController {

    private final CommonService commonService;

    @PostMapping("index/api/login")
    public UserLoginResponseDTO login(@RequestBody UserLoginRequestDTO userLoginRequestDTO, HttpSession httpSession) {
        UserLoginResponseDTO userLoginResponseDTO = commonService.userLogin(userLoginRequestDTO);
        httpSession.setAttribute("user", userLoginResponseDTO);
        return userLoginResponseDTO;
    }

    @PatchMapping("/index/api/admin/modify/{num}")
    public ResponseEntity<String> modify(@PathVariable Long num, @RequestBody UserModifyRequestDTO userModifyRequestDTO, HttpSession session) {

        commonService.userModify(num, userModifyRequestDTO);
        session.invalidate();
        return ResponseEntity.ok("User modified successfully");
    }
}

