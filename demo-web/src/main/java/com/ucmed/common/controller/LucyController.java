package com.ucmed.common.controller;

import com.ucmed.common.model.ConfigBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by ucmed on 2018/3/20.
 * 配置文件初始化bean事例，将配置文件的属性赋给实体类
 */
@RestController
@EnableConfigurationProperties({ConfigBean.class})
public class LucyController {

	@Autowired ConfigBean configBean;

	@RequestMapping(value = "/lucy")
	public String miya(){
		return configBean.getGreeting()+" >>>>"+configBean.getName()+" >>>>"+ configBean.getUuid()+" >>>>"+configBean.getMax();
	}
}
