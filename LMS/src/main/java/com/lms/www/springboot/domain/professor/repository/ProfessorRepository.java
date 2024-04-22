package com.lms.www.springboot.domain.professor.repository;


import com.lms.www.springboot.domain.professor.entity.Professor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface ProfessorRepository extends JpaRepository<Professor, String> {

    @Query("select p from Professor p where p.professor_id=:id and p.password=:pw")
    Professor findByIdAndPassword(@Param("id") String id, @Param("pw") String pw);
}
