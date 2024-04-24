package com.lms.www.springboot.controller;

import com.lms.www.springboot.model.adminFeature.StudentAddRequestDTO;
import com.lms.www.springboot.model.adminFeature.StudentSearchRequestDTO;
import com.lms.www.springboot.model.adminFeature.StudentSearchResponseDTO;
import com.lms.www.springboot.service.CommonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class AdminController {

    private final CommonService commonService;

    @PostMapping("/index/api/admin/StudentAdd")
    public ResponseEntity<String> AdminStudentAdd(@RequestBody StudentAddRequestDTO studentAddRequestDTO) {
        commonService.adminStudentAdd(studentAddRequestDTO);
        return ResponseEntity.ok("");
    }

    @PostMapping("/index/api/admin/studentSearch")
    public ResponseEntity<StudentSearchResponseDTO> adminStudentSearch(@RequestBody StudentSearchRequestDTO studentSearchRequestDTO) {
        StudentSearchResponseDTO studentSearchResponseDTO = commonService.adminStudentSearch(studentSearchRequestDTO);
        return ResponseEntity.ok(studentSearchResponseDTO);
    }


}
