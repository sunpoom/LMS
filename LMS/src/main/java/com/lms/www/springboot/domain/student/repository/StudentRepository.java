package com.lms.www.springboot.domain.student.repository;

import com.lms.www.springboot.domain.student.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, String> {

    @Query("select s from Student s where s.student_id=:id and s.password=:pw")
    Student findByIdAndPassword(@Param("id") String id, @Param("pw") String pw);

    @Query("select s from Student s where s.name=:name and s.student_id=:studentId")
    Student studentSearch(String name, String studentId);
}
