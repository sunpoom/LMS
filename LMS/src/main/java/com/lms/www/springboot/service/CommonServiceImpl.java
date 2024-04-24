package com.lms.www.springboot.service;

import com.lms.www.springboot.domain.admin.service.AdminService;
import com.lms.www.springboot.domain.professor.service.ProfessorService;
import com.lms.www.springboot.domain.student.service.StudentService;
import com.lms.www.springboot.model.adminFeature.*;
import com.lms.www.springboot.model.user.UserLoginRequestDTO;
import com.lms.www.springboot.model.user.UserLoginResponseDTO;
import com.lms.www.springboot.model.user.UserModifyRequestDTO;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.regex.Pattern;

@Service
public class CommonServiceImpl implements CommonService {

    private final AdminService adminService;
    private final ProfessorService professorService;
    private final StudentService studentService;

    public CommonServiceImpl(
            @Qualifier("AdminServiceImpl") AdminService adminService,
            @Qualifier("ProfessorServiceImpl") ProfessorService professorService,
            @Qualifier("StudentServiceImpl") StudentService studentService
    ) {
        this.adminService = adminService;
        this.professorService = professorService;
        this.studentService = studentService;
    }

    @Override
    public UserLoginResponseDTO userLogin(
            UserLoginRequestDTO userLoginRequestDTO
    ) {
        UserLoginResponseDTO dto;

        if (validateUser(userLoginRequestDTO) && checkProfessor(userLoginRequestDTO)) {
            dto = professorService.findByIdAndPassword(userLoginRequestDTO);
        } else if (validateUser(userLoginRequestDTO) && !checkProfessor(userLoginRequestDTO)) {
            dto = studentService.findByIdAndPassword(userLoginRequestDTO);
        } else {
            dto = adminService.findByIdAndPassword(userLoginRequestDTO);
        }

        return dto;
    }

    @Override
    public void userModify(
            Long num,
            UserModifyRequestDTO userModifyRequestDTO
    ) {
        adminService.userModify(num, userModifyRequestDTO);
    }

    @Override
    public void adminStudentAdd(StudentAddRequestDTO studentAddRequestDTO) {
        studentService.adminStudentAdd(studentAddRequestDTO);
    }

    @Override
    public StudentSearchResponseDTO adminStudentSearch(StudentSearchRequestDTO studentSearchRequestDTO) {
        return studentService.adminStudentSearch(studentSearchRequestDTO);
    }

    @Override
    public void adminProfessorAdd(ProfessorAddRequestDTO professorAddRequestDTO) {
        professorService.adminProfessorAdd(professorAddRequestDTO);
    }

    @Override
    public ProfessorSearchResponseDTO adminProfessorSearch(ProfessorSearchRequestDTO professorSearchRequestDTO) {
        return professorService.adminProfessorSearch(professorSearchRequestDTO);
    }

    private boolean validateUser(UserLoginRequestDTO user) {
        String regex = "^[0-9]+$";
        Pattern pattern = Pattern.compile(regex);

        return user.getId().length() == 7 && pattern.matcher(user.getId().substring(1, 7)).matches();
    }

    private boolean checkProfessor(UserLoginRequestDTO userLoginRequestDTO) {
        char code = userLoginRequestDTO.getId().charAt(0);

        return String.valueOf(code).equalsIgnoreCase("p");
    }
}
