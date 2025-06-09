package com.zzz.codesite.pojo;

import lombok.Data;

@Data
public class User {
    private Integer id;
    private String username;
    private String email;
    private Integer age;
    private String gender;
    private String occupation;
    private String password;
}
