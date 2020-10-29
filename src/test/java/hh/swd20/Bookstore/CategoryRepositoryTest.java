package hh.swd20.Bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import hh.swd20.Bookstore.domain.CategoryRepository;
import hh.swd20.Bookstore.domain.Category;


@ExtendWith(SpringExtension.class)  // JUnit5 eli Jupiter
@DataJpaTest



public class CategoryRepositoryTest {
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Test // Testataan CategoryRepositoryn findByName()-metodia
	public void findByNameReturnsCategory() {
		
        List<Category> categories = categoryRepository.findByName("Fiction");
        
        assertThat(categories).hasSize(1);


	}
	
    @Test // Testataan CategoryRepositoryn save()-metodia
    public void createNewCategory() {
    	Category category = new Category("Education");
    	categoryRepository.save(category);
    	assertThat(category.getCategoryid()).isNotNull();
    }  
    
	@Test // BookRepositoryn deleteAll()-metodin testaus
	public void deleteCategory() {

		categoryRepository.deleteAll();
		
		List<Category> categories = categoryRepository.findByName("Horror");
		
		assertThat(categories).hasSize(0);
		
	
	}
}
