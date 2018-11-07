package repositories;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import model.Login;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"/applicationContext.xml"})
public class springLoginTest {
	
	@Autowired 
	private LoginRepository loginRepository;
	
	

	@Test
	public void testLogin() {
		assertNotNull(loginRepository);
		
	}
	
	@Test
	public void createlogin() {
		Login login= new Login("ElComodore", "123456789");
		Login login2= new Login("ElPresidente", "987456321");
		login.setAdmin_id(true);
		login2.setAdmin_id(false);
		loginRepository.save(login);
		loginRepository.save(login2);
		loginRepository.findAll();
		
		for (Login all:loginRepository.findAll()) {
			System.out.println(all.getLogin());
			System.out.println(all.getId());
		};
		
		loginRepository.delete(login2);
		
		for (Login all:loginRepository.findAll()) {
			System.out.println(all.getLogin());
			System.out.println(all.getId());
		};
	}

}
