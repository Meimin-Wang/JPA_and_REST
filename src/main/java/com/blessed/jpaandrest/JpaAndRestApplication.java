package com.blessed.jpaandrest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/**
 * JPA(Java Persistence API)
 *      1. 表结构的创建
 *      2. 表字段的校验
 *      3. 多表关联约束
 *      4. 数据增删改查
 *      5. 自定义查询
 *      6. REST风格接口
 */
@SpringBootApplication
public class JpaAndRestApplication {

    public static void main(String[] args) {
        SpringApplication.run(JpaAndRestApplication.class, args);
    }

}
