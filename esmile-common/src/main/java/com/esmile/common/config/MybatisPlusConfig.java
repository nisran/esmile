package com.esmile.common.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@MapperScan("com.esmile.common.mapper")
@Configuration
public class MybatisPlusConfig {
}
