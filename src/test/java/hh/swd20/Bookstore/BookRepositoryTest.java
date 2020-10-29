package hh.swd20.Bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;


import hh.swd20.Bookstore.domain.Book;
import hh.swd20.Bookstore.domain.BookRepository;


@ExtendWith(SpringExtension.class)  // JUnit5 eli Jupiter
@DataJpaTest

public class BookRepositoryTest {
	
	@Autowired
	private BookRepository bookRepository;
	
	@Test // Testataan BookRepositoryn findByTitle()-metodia
	public void findByTitleReturnsBook() {
		
        List<Book> books = bookRepository.findByTitle("Harry Potter");
        
        assertThat(books).hasSize(1);
        assertThat(books.get(0).getAuthor()).isEqualTo("J.K. Rowling");
		
	}
    @Test // Testataan BookRepositoryn save()-metodia
    public void createNewBook() {
    	Book book = new Book("Iceman - Kimin matkassa", "Heikki Kulta", 2020, "9789523730748", 27.95, null);
    	bookRepository.save(book);
    	assertThat(book.getId()).isNotNull();
    }  
	@Test // BookRepositoryn deleteAll()-metodin testaus
	public void deleteBook() {

		bookRepository.deleteAll();
		
		List<Book> books = bookRepository.findByTitle("Harry Potter");
		
		assertThat(books).hasSize(0);
		
	
	}
//	@Test
//	public void deleteBookById() {
//	Book book = new Book("Isän Ikävä", "Seppo Jokinen", 1996, "951-622-650-7", 19.90, null);
//
//	bookRepository.save(book);
//
//	bookRepository.deleteById(book.getId());
//
//	assertThat(book.getId()).isNull();
//	}
}
