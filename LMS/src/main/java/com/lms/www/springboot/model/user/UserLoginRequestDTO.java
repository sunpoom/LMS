package com.lms.www.springboot.model.user;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class UserLoginRequestDTO {
    private String id;
    private String pw;

    @Builder
    public UserLoginRequestDTO(String id, String pw) {
        this.id = id;
        this.pw = pw;
    }
}
