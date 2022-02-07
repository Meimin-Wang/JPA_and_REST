package com.blessed.jpaandrest.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/**
 * {@link Configuration} 表明该类是配置类
 * {@link EnableJpaAuditing} 启用 {@link AuditingEntityListener}
 * @see com.blessed.jpaandrest.entity.BaseEntity
 * @author blessed
 */
@Configuration
@EnableJpaAuditing
public class JpaConfig {
}
