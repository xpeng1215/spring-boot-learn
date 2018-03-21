package com.ucmed.common.model;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * Created by ucmed on 2018/3/21.
 */
@Component
@ConfigurationProperties(prefix = "web")
@PropertySource(value = "classpath:config/my-web.properties")
public class MyWebConfig {

	private String name;

	private String version;

	private String author;

	public String getAuthor() {
		return author;
	}

	public String getName() {
		return name;
	}

	public String getVersion() {
		return version;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setVersion(String version) {
		this.version = version;
	}
}
