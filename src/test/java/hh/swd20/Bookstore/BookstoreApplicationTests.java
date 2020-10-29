package hh.swd20.Bookstore;


import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import hh.swd20.Bookstore.webcontroller.BookController;
import hh.swd20.Bookstore.webcontroller.CategoryController;


@ExtendWith(SpringExtension.class)
@SpringBootTest
class BookstoreApplicationTests {
	
	@Autowired
	private BookController bookController;
	@Autowired
	private CategoryController categoryController;
	
	@Test
	void ControllersTest() {
		
		assertThat(bookController).isNotNull();
		assertThat(categoryController).isNotNull();
		
	}
	


		
		
	

}
