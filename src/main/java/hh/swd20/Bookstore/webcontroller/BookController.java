package hh.swd20.Bookstore.webcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMethod;

import hh.swd20.Bookstore.domain.BookRepository;

@Controller
public class BookController {
	
		@RequestMapping(value = "/index", method = RequestMethod.GET)
		public String getIndex(Model model) {
		return "index";
		
		}
		
		@Autowired
		private BookRepository bookRepository;
		
		@RequestMapping(value = "/booklist", method = RequestMethod.GET)
		public String getBooks(Model model) {
			model.addAttribute("books", bookRepository.findAll());
			
			return "booklist";
		
		}
}