package com.lms.www.springboot.domain.student.service;

import com.lms.www.springboot.domain.student.entity.Student;
import com.lms.www.springboot.domain.student.repository.StudentRepository;
import com.lms.www.springboot.exception.EntityNotFoundException;
import com.lms.www.springboot.model.adminFeature.StudentAddRequestDTO;
import com.lms.www.springboot.model.adminFeature.StudentSearchRequestDTO;
import com.lms.www.springboot.model.adminFeature.StudentSearchResponseDTO;
import com.lms.www.springboot.model.user.UserLoginRequestDTO;
import com.lms.www.springboot.model.user.UserLoginResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    @Override
    @Transactional
    public UserLoginResponseDTO findByIdAndPassword(UserLoginRequestDTO userLoginRequestDTO) {
        Student student = studentRepository.findByIdAndPassword(
                userLoginRequestDTO.getId(),
                userLoginRequestDTO.getPw()
        );

        if (student == null) {
            throw new EntityNotFoundException("해당아이디랑 비밀번호가 다릅니다");
        }

        return new UserLoginResponseDTO(student);
    }

    @Override
    public void adminStudentAdd(StudentAddRequestDTO studentAddRequestDTO) {
        studentRepository.save(studentAddRequestDTO.toEntity());
    }

    @Override
    public StudentSearchResponseDTO adminStudentSearch(StudentSearchRequestDTO studentSearchRequestDTO) {
        Student student = studentRepository.studentSearch(studentSearchRequestDTO.getName(), studentSearchRequestDTO.getStudent_id());
        if (student == null) {
            throw new EntityNotFoundException("해당 이름과 학번은 존재하지않습니다.");
        }
        return new StudentSearchResponseDTO(student);
    }
}
