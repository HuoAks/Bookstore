package hh.swd20.Bookstore.webcontroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BookController {
	
		@RequestMapping(value = "/index", method = RequestMethod.GET)
		public String getIndex(Model model) {
		return "index";
		
		}
}