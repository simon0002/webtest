package com.example.webtest.config;

import com.example.webtest.component.LoginHandlerInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class WebConfigurer implements WebMvcConfigurer {
	@Autowired
    private LoginHandlerInterceptor loginInterceptor;

  // 这个方法是用来配置静态资源的，比如html，js，css，等等
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {

	}
	 
	// 这个方法用来注册拦截器，我们自己写好的拦截器需要通过这里添加注册才能生效
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// addPathPatterns("/**") 表示拦截所有的请求，
		// excludePathPatterns ("/login", "/register"); //表示除了登陆与注册之外，因为登陆注册不需要登陆也可以访问
	      	  registry.addInterceptor(loginInterceptor).addPathPatterns("/**").excludePathPatterns("/login", "/doLogin", "/webtest/jsws");

	      //	  super.addInterceptors(registry);    //较新Spring Boot的版本中这里可以直接去掉，否则会报错
	}
	   
//	@Bean
//	public WebMvcConfigurer corsConfigurer()
//	{
//		return new WebMvcConfigurer() {
//			@Override
//			public void addCorsMappings(CorsRegistry registry) {
//				registry.addMapping("/**").
//						allowedOrigins("*"). //允许跨域的域名，可以用*表示允许任何域名使用
//						allowedMethods("*"). //允许任何方法（post、get等）
//						allowedHeaders("*"). //允许任何请求头
//						allowCredentials(true). //带上cookie信息
//						exposedHeaders(HttpHeaders.SET_COOKIE).maxAge(3600L); //maxAge(3600)表明在3600秒内，不需要再发送预检验请求，可以缓存该结果
//			}
//		};
//	}

}
