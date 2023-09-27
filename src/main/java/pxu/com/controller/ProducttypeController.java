package pxu.com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pxu.com.model.Producttype;
import pxu.com.service.ProductTypeService;

@Controller
@RequestMapping("/producttype")
public class ProducttypeController {

	@RequestMapping("/add")
	public String processAddProductForm(@ModelAttribute("producttype") Producttype producttype) {
		return "/home";
	}

	@Autowired
	private ProductTypeService producttypeService;

	@GetMapping("/listproducttype")
	public String listproduct(Model model) {
		List<Producttype> producttypes = producttypeService.getAll();
		model.addAttribute("producttypes", producttypes);
		return "listproducttype";
	}

	@PostMapping("/save")
	@Transactional
	public String saveproduct(@ModelAttribute("product") Producttype producttype) {
		producttypeService.save(producttype);
		return "redirect:/producttype/listproducttype";
	}

	@GetMapping("/delete")
	@Transactional
	public String delete(@ModelAttribute("producttypeId") int id) {
		producttypeService.delete(id);
		return "redirect:/producttype/listproducttype";
	}

	@GetMapping("/update")
	public String updateform(@RequestParam("producttypeId") int id, Model model) {
		Producttype producttype = producttypeService.getById(id);
		model.addAttribute("producttype", producttype);
		return "updateproducttype";
	}

	@PostMapping("/edit")
	@Transactional
	public String updateProduct(@ModelAttribute("producttype") Producttype producttype) {
		producttypeService.update(producttype);
		return "redirect:/producttype/listproducttype";
	}
}
