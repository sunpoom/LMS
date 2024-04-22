package com.lms.www.springboot.config;


import com.lms.www.springboot.domain.admin.repository.AdminRepository;
import com.lms.www.springboot.domain.admin.service.AdminService;
import com.lms.www.springboot.domain.admin.service.AdminServiceImpl;
import com.lms.www.springboot.domain.professor.repository.ProfessorRepository;
import com.lms.www.springboot.domain.professor.service.ProfessorService;
import com.lms.www.springboot.domain.professor.service.ProfessorServiceImpl;
import com.lms.www.springboot.domain.student.repository.StudentRepository;
import com.lms.www.springboot.domain.student.service.StudentService;
import com.lms.www.springboot.domain.student.service.StudentServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceConfig {

    @Bean(name = "AdminServiceImpl")
    public AdminService adminServiceImpl(AdminRepository adminRepository) {
        return new AdminServiceImpl(adminRepository);
    }

    @Bean(name = "StudentServiceImpl")
    public StudentService studentServiceImpl(StudentRepository studentRepository) {
        return new StudentServiceImpl(studentRepository);
    }

    @Bean(name = "ProfessorServiceImpl")
    public ProfessorService professorServiceImpl(ProfessorRepository professorRepository) {
        return new ProfessorServiceImpl(professorRepository);
    }
}