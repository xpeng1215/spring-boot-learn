package com.ucmed.common.controller;

import com.ucmed.common.model.MyWebConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by ucmed on 2018/3/21.
 * 自定义配置文件加载事例
 * 1、在@EnableConfigurationProperties取消激活自定义的配置类（重要）
 * 2、在配置类中采用@Component的方式注册为组件，然后使用@PropertySource来指定自定义的资源目录
 */
@RestController
public class CustomProfileController {

	@Autowired
	private MyWebConfig myWebConfig;

	@RequestMapping(value = "/web")
	public String user(){
		return "webName: "+myWebConfig.getName()+", webVersion: "+
				myWebConfig.getVersion()+", webAuthor: "+myWebConfig.getAuthor();
	}

}
