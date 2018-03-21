package com.ucmed.common.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by ucmed on 2018/3/20.
 * 配置文件加载事例
 */
@RestController
public class LoadApplicationController {

	@Value("${my.name}")
	private String name;

	@Value("${my.age}")
	private int age;

	@RequestMapping(value = "/loadApplication")
	public String loadApplication(){
		return name+":"+age;
	}

}
