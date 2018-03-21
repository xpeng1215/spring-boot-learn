package com.ucmed.common.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by ucmed on 2018/3/20.
 */
@RestController
public class HelloController {

	@RequestMapping("/index.htm")
	public String index() {
			return "hello world";
		}
}
