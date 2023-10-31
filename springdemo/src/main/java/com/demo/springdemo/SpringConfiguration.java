//package com.demo.springdemo;
// 
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
// 
//import com.demo.springdemo.library.CartComponent;
//import com.demo.springdemo.library.ProductComponent;
// 
//@Configuration
//public class SpringConfiguration {
//	@Bean
//	public ProductComponent getProduct() {
//		return new ProductComponent();
//	}
//	@Bean
//	public CartComponent getCart() {
//		return new CartComponent();
//	}
//}





package com.demo.springdemo;
 
//import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
 
@Configuration
@ComponentScan(basePackages = {"com.demo.springdemo"})
@PropertySource(value= {"classpath:/application.properties"})
public class SpringConfiguration {
//	@Bean
//	public ProductComponent getProduct() {
//		return new ProductComponent();
//	}
//	@Bean
//	public CartComponent getCart() {
//		return new CartComponent();
//	}
}