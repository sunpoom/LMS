package com.lms.www.springboot.model.user;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class UserModifyRequestDTO {
    private String id;
    private String email;
    private String pw;

    @Builder
    public UserModifyRequestDTO(String id, String email, String pw) {
        this.id = id;
        this.email = email;
        this.pw = pw;
    }
}
