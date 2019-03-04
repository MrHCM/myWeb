package myWeb.qn215.config;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;




/**
 *
 * @author wangchunzi
 */
@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {
	@Autowired
	private ServletContext servletContext;
	
	
	
	
	@Override
	public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
		configurer.mediaType("json", MediaType.APPLICATION_JSON);
        configurer.mediaType("xml", MediaType.APPLICATION_XML);
	}
	/**
	 * 拦截器
	 */
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		System.out.println("=============================注册拦截器成功！=================================");
	        registry.addInterceptor(new Admin()).addPathPatterns("/**");
	}

	@Override
	public void addFormatters(FormatterRegistry registry) {
		System.out.println("=============================注册转换器器成功！=================================");
		registry.addConverter(new StringtoDateConver());;
	}
	
	/**
	 * 视图
	 */
	@Override
	public  void addViewControllers(ViewControllerRegistry registry) {
		//跳转设置访问/时，跳转到 视图index
		 registry.addViewController("/").setViewName("login");
		
		 //registry.addViewController("/user/logindl").setViewName("frame");
		 //重定向跳转
		 registry.addRedirectViewController("/user/logindl", "frame");
		 
		 //registry.addStatusController("hello2", HttpStatus.BAD_GATEWAY);
	}


	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		
		PathConfig pconfig=new PathConfig();
		pconfig.set(this.servletContext.getRealPath(""));
		
		registry.addResourceHandler("/static/**")
		.addResourceLocations("/public", "/static/")
		.setCachePeriod(31556926);
		System.out.println("=============================注册成功=================================");
		System.out.println("项目运行时真实路径"+PathConfig.getRealPath(""));
		// 初始化项目的绝对路径
		/*PathConfig pconfig=new PathConfig();
		String path=servletContext.getRealPath("");
		System.out.println(path);
		if (!path.endsWith("/")) {//如果不是/结尾。我们加上结尾
			path=path+"/";
		}*/
		
	}

}
