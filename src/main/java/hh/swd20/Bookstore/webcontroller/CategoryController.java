package hh.swd20.Bookstore.webcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMethod;

import hh.swd20.Bookstore.domain.Category;
import hh.swd20.Bookstore.domain.CategoryRepository;

@Controller
public class CategoryController {
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	// List all categories
	@RequestMapping(value = "/categorylist", method = RequestMethod.GET)
	public String getCategories(Model model) {
	model.addAttribute("categories", categoryRepository.findAll());
	return "categorylist";
	}
	
	// Add a category
	@RequestMapping(value = "/new")
	public String addCategory(Model model) {
		model.addAttribute("category", new Category());
		return "newcategory";
		
	}
	// Save a category
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String createCategory(Category category) {
		categoryRepository.save(category);
		return "redirect:categorylist";
	}
}