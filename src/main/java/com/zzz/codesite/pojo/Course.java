package com.zzz.codesite.pojo;

import lombok.Data;

@Data
public class Course {
    private Integer id;
    private String course_name;
    private String author;
    private String description;
    private String type;
}
