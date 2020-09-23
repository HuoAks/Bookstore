package hh.swd20.Bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hh.swd20.Bookstore.domain.Book;
import hh.swd20.Bookstore.domain.BookRepository;


@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	@Bean
	public CommandLineRunner demo(BookRepository bookRepository) {
	return (args) -> {
	
		Book book1 = new Book("Harry Potter", "J.K. Rowling", 1997, "1234" );
		Book book2 = new Book("Musta Kobra", "Ilkka Remes", 2004, "5678" );
		bookRepository.save(book1);	// Saving the first book into the db.
		bookRepository.save(book2); // Saving the 2nd book into the db.
		
	};
}
}