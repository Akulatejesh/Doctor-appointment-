package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
 
import com.example.demo.model.Product;
import com.example.demo.service.ProductService;
 
@Controller
public class ProductController {
	@Autowired
	ProductService service;
	@GetMapping("/display")
	public String displayProduct(Model model) {
		Product myprd=service.getProductById(2);
		model.addAttribute("product", myprd);
		return "displayProduct";
	}
	@GetMapping("/displayList")
	public String displayProductList(Model model) {
		Iterable<Product> prdList=service.getAllProducts();
		model.addAttribute("prdlist", prdList);
		return "productListing";
	}
	@GetMapping("/addProduct")
	public ModelAndView addProductForm() {
		ModelAndView mv= new ModelAndView();
	   mv.addObject("product",new Product());
	   mv.setViewName("addProduct");
	return mv;
	}
	@PostMapping("/addProduct")
	@ResponseBody
	public String  addNewProduct(Product prd) {
		
		return  service.saveProduct(prd);
		
	}
	@GetMapping("/user")
	public ModelAndView printUser() {
		ModelAndView mv=new ModelAndView();
		mv.addObject("user","Admin");
		mv.setViewName("user");
		return mv;
	}
}