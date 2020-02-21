package com.nowcoder.community;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;


@SpringBootApplication
public class CommunityApplication {

	// 管理 bean 的生命周期
	@PostConstruct
	public void init(){
		// 解决netty启动冲突问题
		System.setProperty("es.set.netty.runtime.available.processors","false");
	}

	// SpringApplication 是Spring管理Bean的容器
	public static void main(String[] args) {
		SpringApplication.run(CommunityApplication.class, args);
	}

}
