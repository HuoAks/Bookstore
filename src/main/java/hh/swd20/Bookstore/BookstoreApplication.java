package hh.swd20.Bookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


import hh.swd20.Bookstore.domain.Book;
import hh.swd20.Bookstore.domain.BookRepository;
import hh.swd20.Bookstore.domain.Category;
import hh.swd20.Bookstore.domain.CategoryRepository;


@SpringBootApplication
public class BookstoreApplication {
	
	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);


	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	@Bean
	public CommandLineRunner demo(BookRepository bookRepository, CategoryRepository categoryRepository) {
	return (args) -> {
		
		log.info("Save some books");
		Category category1 = new Category("Horror");
		categoryRepository.save(category1);  // saving the 1st category
		Category category2 = new Category("Fantasy");
		categoryRepository.save(category2);  //saving the 2nd category					
		Category category3 = new Category("Romance");
		categoryRepository.save(category3); //saving the 3rd category
		Category category4 = new Category("Fiction");
		categoryRepository.save(category4); 
		
		
		bookRepository.save(new Book("Harry Potter", "J.K. Rowling", 1997, "1234", 19.50, category2));	// Saving the first book with category.
		bookRepository.save(new Book("Musta Kobra", "Ilkka Remes", 2004, "5678", 18.30, category4)); // Saving the 2nd book with category.
		
		log.info("fetch all books");
		for (Book book : bookRepository.findAll()) {
			log.info(book.toString());
			
		}
	};
	
	}

}
