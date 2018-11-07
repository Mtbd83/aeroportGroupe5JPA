package service;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import model.Passager;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/applicationContext.xml"})
public class TestPassagerService {
	
	@Autowired
	private PassagerService passagerService;
	
	@Test
	public void test() {
//		Passager passager= new Passager();
//		passager.setNom("Saidani");
//		passager.setPrenom("Tanguy");
		//passagerService.createPassager(passager);
		
//		passagerService.modifyPassagerFirstname(passager, "Tanguette");
		
		passagerService.deletePassagerByName("Tanguette");
		
		
	}
	

}
