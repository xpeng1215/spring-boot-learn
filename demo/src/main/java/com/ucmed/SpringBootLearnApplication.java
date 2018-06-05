package com.ucmed;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@SpringBootApplication
@EnableCaching  // 开启redis注解
@Component
@PropertySource(value = "classpath:config/jdbc.properties")  // 加载自定义的数据库配置信息
public class SpringBootLearnApplication {

	@Autowired
	private Environment env;

	@Bean
	public RedisCacheConfiguration redisCacheConfiguration() {
		return RedisCacheConfiguration
				.defaultCacheConfig()
				.serializeKeysWith(
						RedisSerializationContext
								.SerializationPair
								.fromSerializer(new StringRedisSerializer()))
				.serializeValuesWith(
						RedisSerializationContext
								.SerializationPair
								.fromSerializer(new GenericJackson2JsonRedisSerializer()));
	}

	@Bean
	public DataSource dataSource() {
		DruidDataSource dataSource = new DruidDataSource();
		dataSource.setUrl(env.getProperty("spring.datasource.url"));
		dataSource.setUsername(env.getProperty("spring.datasource.username"));//用户名
		dataSource.setPassword(env.getProperty("spring.datasource.password"));//密码
		dataSource.setDriverClassName(env.getProperty("spring.datasource.driver-class-name"));
		dataSource.setInitialSize(2);
		dataSource.setMaxActive(20);
		dataSource.setMinIdle(0);
		dataSource.setMaxWait(60000);
		dataSource.setValidationQuery("SELECT 1");
		dataSource.setTestOnBorrow(false);
		dataSource.setTestWhileIdle(true);
		dataSource.setPoolPreparedStatements(false);
		return dataSource;
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringBootLearnApplication.class, args);
	}

}
