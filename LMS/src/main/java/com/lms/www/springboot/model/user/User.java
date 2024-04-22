package com.lms.www.springboot.model.user;

public enum User {
    UNKNOWN,
    PROFESSOR,
    ADMIN,
    STUDENT;

    public User checkUser(UserLoginRequestDTO userLoginRequestDTO) {
        String user = userLoginRequestDTO.getId();

        if (user.startsWith("p")) {
            return User.PROFESSOR;
        } else {
            return User.STUDENT;
        }
    }
}
