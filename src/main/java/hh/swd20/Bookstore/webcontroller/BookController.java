package hh.swd20.Bookstore.webcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMethod;

import hh.swd20.Bookstore.domain.BookRepository;
import hh.swd20.Bookstore.domain.Book;

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
		// Delete a book
		@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
		public String deleteBook(@PathVariable("id") Long bookId, Model model) {
			bookRepository.deleteById(bookId);
			return "redirect:../booklist";
		}
		// Add a book
		@RequestMapping(value = "/add")
		public String addBook(Model model) {
			model.addAttribute("book", new Book());
			return "addbook";
		}
		// Save a book
		@RequestMapping(value = "/save", method = RequestMethod.POST)
		public String saveBook(Book book) {
			bookRepository.save(book);
			return "redirect:booklist";
		}
}