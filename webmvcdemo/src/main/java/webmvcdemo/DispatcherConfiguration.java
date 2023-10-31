package webmvcdemo;
 
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
 
import org.springframework.context.annotation.Configuration;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
 
 
@Configuration
public class DispatcherConfiguration implements WebApplicationInitializer{
 
	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		//Initialize the IOC Container
		AnnotationConfigWebApplicationContext context=new AnnotationConfigWebApplicationContext();
		context.register(SpringConfiguration.class);	
		//Create a dispatcher Servlet at runtime(Dynamic)
		ServletRegistration.Dynamic register=servletContext.addServlet("ds",new DispatcherServlet (context)); //bind DS with IOC
		register.setLoadOnStartup(1);
		register.addMapping("/"); //http://localhost:8080/SpringDemo to be routed to the ds
		
	}
	
 
 
}