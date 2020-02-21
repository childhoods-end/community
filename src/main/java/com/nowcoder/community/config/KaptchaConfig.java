package com.nowcoder.community.config;

import com.google.code.kaptcha.Producer;
import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.google.code.kaptcha.util.Config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

// 因为 Kaptcha未被Spring整合，所以要自己对其进行配置
@Configuration
public class KaptchaConfig {

    // Producer：核心接口
    @Bean
    public Producer kaptchaProducer() {
        Properties properties = new Properties();
        properties.setProperty("kaptcha.image.width", "100");
        properties.setProperty("kaptcha.image.height", "40");
        properties.setProperty("kaptcha.textproducer.font.size", "32");
        properties.setProperty("kaptcha.textproducer.font.color", "0,0,0");
        properties.setProperty("kaptcha.textproducer.char.string", "123456789ABCDEFGHIJKLMNPQRSTUVWXYAZ");
        properties.setProperty("kaptcha.textproducer.char.length", "4");
        // 采用的噪声类：图片中的干扰，线等。此处为无噪声类，因其自带有噪声
        properties.setProperty("kaptcha.noise.impl", "com.google.code.kaptcha.impl.NoNoise");

        // Kaptcha的实现类
        DefaultKaptcha kaptcha = new DefaultKaptcha();
        // 用于封装配置参数
        Config config = new Config(properties);
        kaptcha.setConfig(config);
        return kaptcha;
    }

}
