package com.lms.www.springboot.domain.professor.service;

import com.lms.www.springboot.domain.professor.entity.Professor;
import com.lms.www.springboot.domain.professor.repository.ProfessorRepository;
import com.lms.www.springboot.exception.EntityNotFoundException;
import com.lms.www.springboot.model.adminFeature.ProfessorAddRequestDTO;
import com.lms.www.springboot.model.adminFeature.ProfessorSearchRequestDTO;
import com.lms.www.springboot.model.adminFeature.ProfessorSearchResponseDTO;
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

    @Override
    public void adminProfessorAdd(ProfessorAddRequestDTO professorAddRequestDTO) {
        professorRepository.save(professorAddRequestDTO.toEntity());
    }

    @Override
    public ProfessorSearchResponseDTO adminProfessorSearch(ProfessorSearchRequestDTO professorSearchRequestDTO) {
        Professor professor = professorRepository.professorSearch(professorSearchRequestDTO.getName(), professorSearchRequestDTO.getProfessor_id());
        if (professor == null) {
            throw new EntityNotFoundException("해당 이름과 학번이 존재하지않습니다.");
        }
        return new ProfessorSearchResponseDTO(professor);
    }
}
