package com.zzz.codesite;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan
@SpringBootApplication
public class CodeSiteApplication {

    public static void main(String[] args) {
        SpringApplication.run(CodeSiteApplication.class, args);
    }

}
