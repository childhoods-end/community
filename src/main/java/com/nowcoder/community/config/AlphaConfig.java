package com.nowcoder.community.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;

// 配置类
@Configuration
public class AlphaConfig {

    // 定义第三方的 Bean,从 jar包等导入
    @Bean
    public SimpleDateFormat simpleDateFormat(){

        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    }
}
