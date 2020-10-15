package hh.swd20.Bookstore.webcontroller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


import hh.swd20.Bookstore.domain.BookRepository;
import hh.swd20.Bookstore.domain.Book;
import hh.swd20.Bookstore.domain.CategoryRepository;
import hh.swd20.Bookstore.domain.Category;

@Controller
public class BookController {
	
		@RequestMapping(value = "/index", method = RequestMethod.GET)
		public String getIndex(Model model) {
		return "index";
		
		}
	    @RequestMapping(value="/login")
	    public String login() {	
	        return "login";
	    }	
		
		@Autowired
		private BookRepository bookRepository;
		
		@Autowired
		private CategoryRepository categoryRepository;
		
		// List all books
		@RequestMapping(value = "/booklist", method = RequestMethod.GET)
		public String getBooks(Model model) {
			model.addAttribute("books", bookRepository.findAll());
			
			return "booklist";
		
		}
		// Delete a book
		@PreAuthorize("hasAuthority('ADMIN')")
		@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
		public String deleteBook(@PathVariable("id") Long bookId, Model model) {
			bookRepository.deleteById(bookId);
			return "redirect:../booklist";
		}
		// Add a book
		@RequestMapping(value = "/add")
		public String addBook(Model model) {
			model.addAttribute("book", new Book());
			model.addAttribute( "categories", categoryRepository.findAll());
			return "addbook";
		}
		// Save a book
		@RequestMapping(value = "/save", method = RequestMethod.POST)
		public String saveBook(Book book) {
			bookRepository.save(book);
			return "redirect:booklist";
		}
		
		// Edit a book
		@RequestMapping("/edit/{id}")
		public String editBook(@PathVariable("id") Long bookId, Model model) {
		model.addAttribute("book", bookRepository.findById(bookId));
		model.addAttribute("categories", categoryRepository.findAll());
		return "editbook";
		}
		// RESTful service to get all books
	    @RequestMapping(value="/books", method = RequestMethod.GET)
	    public @ResponseBody List<Book> bookListRest() {	
	        return (List<Book>) bookRepository.findAll();
	    }    

		// RESTful service to get a book by id
	    @RequestMapping(value="/books/{id}", method = RequestMethod.GET)
	    public @ResponseBody Optional<Book> findBookRest(@PathVariable("id") Long bookId) {	
	    	return bookRepository.findById(bookId);
	    } 
}