### restful

spring mvc简单实现restful风格, Spring mvc在接收put请求参数时候会发生获取不到参数问题, 需要配置一个filter.

1. spring bean方式:
```
@Bean
public FilterRegistrationBean registration() {
	FilterRegistrationBean bean = new FilterRegistrationBean(new HttpPutFormContentFilter());
	return bean;
}
	
``` 
2. xml方式, 在web.xml中添加
```
<filter>
	<filter-name>HttpMethodFilter</filter-name>
	<filter-class>org.springframework.web.filter.HttpPutFormContentFilter</filter-class>
</filter>
<filter-mapping>
	<filter-name>HttpMethodFilter</filter-name>
	<url-pattern>/*</url-pattern>
</filter-mapping>
```

之后再传递参数时候添加一个{"_method":"put"}, 或者在表单添加隐藏域: `<input type="hidden" name="_method" value="put" />`