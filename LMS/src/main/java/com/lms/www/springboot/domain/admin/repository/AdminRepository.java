package com.lms.www.springboot.domain.admin.repository;

import com.lms.www.springboot.domain.admin.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {
    @Query(value = "select a from Admin a where a.admin_id=:id and a.password=:pw")
    Admin findByIdAndPassword(@Param("id") String id, @Param("pw") String pw);
}
