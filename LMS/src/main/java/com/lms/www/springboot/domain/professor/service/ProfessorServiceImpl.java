package com.lms.www.springboot.domain.professor.service;

import com.lms.www.springboot.domain.professor.entity.Professor;
import com.lms.www.springboot.domain.professor.repository.ProfessorRepository;
import com.lms.www.springboot.exception.EntityNotFoundException;
import com.lms.www.springboot.model.user.UserLoginRequestDTO;
import com.lms.www.springboot.model.user.UserLoginResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class ProfessorServiceImpl implements ProfessorService {

    private final ProfessorRepository professorRepository;

    @Override
    @Transactional
    public UserLoginResponseDTO findByIdAndPassword(UserLoginRequestDTO userLoginRequestDTO) {
        Professor professor = professorRepository.findByIdAndPassword(
                userLoginRequestDTO.getId(),
                userLoginRequestDTO.getPw()
        );

        if (professor == null) {
            throw new EntityNotFoundException("해당아이디랑 비밀번호가 다릅니다");
        }

        return new UserLoginResponseDTO(professor);
    }
}
