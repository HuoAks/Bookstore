package hh.swd20.Bookstore;

import static org.assertj.core.api.Assertions.assertThat;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;


import hh.swd20.Bookstore.domain.User;
import hh.swd20.Bookstore.domain.UserRepository;


@ExtendWith(SpringExtension.class)  // JUnit5 eli Jupiter
@DataJpaTest

public class UserRepositoryTest {
	
	@Autowired
	private UserRepository urepository;
	
	@Test // Testataan UserRepositoryn findByUsername()-metodia ????
		public void findByUsernameReturnsUser() {
			
		assertThat(urepository.findByUsername("akseli")).isNotNull();
		assertThat(urepository.findByUsername("user")).isNotNull();
	       
		
		
		}
	
	@Test // Testataan UserRepositoryn save()-metodia, tallenetaan uusi käyttäjä test/test
	public void saveNewUserTest() {
	User user = new User("test", "$2a$10$ZBg7H8q.jD9yPoks9bRLQO/5lxx.qDLTLXmO0.1NC8VSA1lP6nNiq", "USER", "test@demouser.db");
	urepository.save(user);
	assertThat(urepository.findByUsername("test")).isNotNull();
	
	
	}
	@Test // UserRepositoryn deleteAll()-metodin testaus. Commandlinerunnerilla luotuja käyttäjiä ei löydy deleteAll()-metodin jälkeen.
	public void deleteAllUsers() {

		urepository.deleteAll();
		
		assertThat(urepository.findByUsername("akseli")).isNull();
		assertThat(urepository.findByUsername("user")).isNull();
		
		
	
	}
	

	@Test // UserRepositoryn deleteById()-metodin testaus
	public void deleteUserByIdTest() {
		User user = new User("test", "$2a$10$ZBg7H8q.jD9yPoks9bRLQO/5lxx.qDLTLXmO0.1NC8VSA1lP6nNiq", "USER", "test@demouser.db");
	
		urepository.save(user);
	
		urepository.deleteById(user.getId());
	
		assertThat(urepository.findByUsername("test")).isNull();
}

}
