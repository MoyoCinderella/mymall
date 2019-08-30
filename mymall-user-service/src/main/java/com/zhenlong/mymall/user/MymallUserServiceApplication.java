package com.zhenlong.mymall.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan("com.zhenlong.mymall.user.mapper")
public class MymallUserServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(MymallUserServiceApplication.class, args);
    }

}
