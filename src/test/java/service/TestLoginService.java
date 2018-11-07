package service;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import model.Login;
import repositories.LoginRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"/applicationContext.xml"})
public class TestLoginService {

@Autowired
LoginService loginService;
@Autowired
LoginRepository LoginRepository;

@Test
public void testService() {
	Login login= new Login("Kamen Raider", "Sentai");
	loginService.CreateLogin(login);
	assertNotNull(LoginRepository);
	for (Login all:loginService.showAllLogin()) {
		System.out.println(all.getLogin());
		System.out.println(all.getId());
	};
	
}
}
