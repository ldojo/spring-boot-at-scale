package com.mumms.security;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@SpringBootApplication
public class SecurityTestApplication {

	@Configuration
	@EnableWebSecurity
	public class SecurityConfig extends WebSecurityConfigurerAdapter{
		
		@Override
		protected void configure(AuthenticationManagerBuilder auth) throws Exception {
			auth.inMemoryAuthentication().withUser("lev").password("lev").roles("USER");
		}
		
//		@Override
//		protected void configure(HttpSecurity http) throws Exception {
//				http.csrf().disable()
//				.authorizeRequests().antMatchers("/**/*.html").authenticated();
//				
//
//		}

	}
	
//	@Configuration
//	@EnableRedisHttpSession
//	public class SessionConfig {
//		@Bean
//		public JedisConnectionFactory connectionFactory() {
//			String redisHost = "redis", redisPort = "6379";
//
//			JedisConnectionFactory factory = new JedisConnectionFactory();
//			//if either of these are null, the app will just fail to startup -- which is actually what we want
//			factory.setHostName(redisHost);
//			factory.setPort(new Integer(redisPort) );
//			return factory;
//		}
//	}
	
	public static void main(String[] args) {
		SpringApplication.run(SecurityTestApplication.class, args);
	}
}
