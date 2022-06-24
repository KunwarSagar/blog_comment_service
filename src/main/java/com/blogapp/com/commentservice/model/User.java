package com.blogapp.com.commentservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private Long userId;
    private String fullname;
    private String email;
    private String username;
    private String password;

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", fullname='" + fullname + '\'' +
                ", email='" + email + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
