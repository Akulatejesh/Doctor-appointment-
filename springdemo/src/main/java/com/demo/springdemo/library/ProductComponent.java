//package com.demo.springdemo.library;
// 
//import java.util.List;
// 
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.annotation.AnnotationConfigApplicationContext;
// 
//import com.demo.springdemo.SpringConfiguration;
// 
//public class ProductComponent {
//	CartComponent cart;
//	public void setCart() {
//		ApplicationContext context=new AnnotationConfigApplicationContext(SpringConfiguration.class);
//		cart=context.getBean(CartComponent.class);
//	}
//	public List<String> viewAddProduct(String prdname){
//		return cart.addProduct(prdname);
//	}
//}





package com.demo.springdemo.library;
 
import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
@Component
//@Scope(value="prototype")
public class ProductComponent {
	@Autowired
	CartComponent cart;
	@Value("${cname}")
	String cname;
	public List<String> viewAddProduct(String prdname){
		return cart.addProduct(cname + ":" + prdname);
	}
}