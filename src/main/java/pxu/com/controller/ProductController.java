package pxu.com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pxu.com.model.Product;
import pxu.com.model.Producttype;
import pxu.com.service.ProductService;
import pxu.com.service.ProductTypeService;

@Controller
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductService productService;

	@Autowired
	private ProductTypeService productTypeService;

	@RequestMapping("/add")
	public String processAddProductForm(@ModelAttribute("productt") Product product) {
		return "/homeproduct";
	}

	@GetMapping("/listproduct")
	public String listproduct(Model model) {
		List<Product> products = productService.getAll();
		model.addAttribute("products", products);
		return "listproduct";
	}

	@PostMapping("/saveproduct")
	@Transactional
	public String saveproduct(@ModelAttribute("productt") Product product) {
		productService.save(product);
		return "redirect:/product/listproduct";
	}

	@GetMapping("/deleteproduct")
	@Transactional
	public String delete(@ModelAttribute("productId") int id) {
		productService.delete(id);
		return "redirect:/product/listproduct";
	}

	@GetMapping("/updateproduct")
	public String updateform(@RequestParam("productId") int id, Model model) {
		Product product = productService.getById(id);
		model.addAttribute("product", product);
		return "update";
	}

	@PostMapping("/edit")
	@Transactional
	public String updateProduct(@ModelAttribute("product") Product product) {
		productService.update(product);
		return "redirect:/product/listproduct";
	}

	@ModelAttribute("producttype")
	public List<Producttype> provinces() {
		return productTypeService.getAll();
	}

}
