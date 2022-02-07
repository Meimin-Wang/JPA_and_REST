package com.blessed.jpaandrest.entity;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * {@link Data} 可以自动生成getter/setter等方法，但是在JPA会损伤性能
 * {@link MappedSuperclass} 代表这一个用户继承的基类，不会被创建表
 * {@link EntityListeners} 该注解需要标注在 {@link MappedSuperclass} 上
 * {@link AuditingEntityListener} 需要在JPA配置文件开启 {@link org.springframework.data.jpa.repository.config.EnableJpaAuditing}
 * @author Blessed
 */
@Data
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class BaseEntity implements Serializable {
    /**
     * {@link Id}: 每一个实体必须要有一个id字段，并标注 {@link Id} 注解
     * {@link GeneratedValue}: id生成策略，在MySQL中通常使用自增方式，也就是 {@link javax.persistence.GenerationType} 中提供的各种选择
     *      strategy: 主键生成策略，是 {@link javax.persistence.GenerationType}
     *          AUTO, IDENTITY, TABLE, SEQUENCE，根据不同的数据库类型不同的主键生成策略
     * {@link Column}: 表示数据表中某一列，可以配置列名称
     *      name: 列的名称
     *      unique: 是否是单一的，不能重复的
     *      nullable: 是否可以为空
     *      insertable: 是否可以通过SQL的INSERT语句进行插入
     *      updatable: 是否可以通过SQL的UPDATE语句进行更新
     *      length: 长度，比如整型、可变字符类型等长度指定
     *      precision: 精度
     *      scale: 浮点数范围
     */
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id")
    private Long id;

    /**
     * {@link CreatedDate} 表明该字段是创建时间字段，当保存操作的时候可以进行记录创建时间
     */
    @CreatedDate
    @Column(name = "create_time")
    private Date createTime = new Date();

    /**
     * {@link LastModifiedDate} 当该记录使用UPDATE语句修改的时候会同时更新该字段时间
     */
    @LastModifiedDate
    @Column(name = "update_time")
    private Date updateTime = new Date();
}
