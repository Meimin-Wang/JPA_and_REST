package com.blessed.jpaandrest.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * {@link Entity} 标记该类是一个实体类
 *      name: 表的名称，如果不提供名称，那么使用类的名称作为表的名称
 * {@link Table} 这是 java.persistence包下的注解，为该实体对应的表提供一些额外的信息，比如从表 {@link javax.persistence.SecondaryTable} 和 {@link javax.persistence.SecondaryTables}
 *      name: 和 {@link Entity} 中的name属性相同，表示表的名称
 *      schema: 表示该实体对应表的schema
 *
 */
@Data
@Entity(name = "tbl_user")
@Table(name = "tbl_user")
@org.hibernate.annotations.Table(
        appliesTo = "tbl_user",
        comment = "用户表"
)
public class User extends BaseEntity {

    @Column(name = "username", length = 30, unique = true, nullable = false)
    private String username;

    @Column(name = "password", length = 255, unique = true, nullable = false)
    private String password;

    @Temporal(TemporalType.DATE)
    @Column(name = "birthday")
    private Date birthday;
}
