package repositories;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import model.Client;
import model.Passager;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/applicationContext.xml"})
public class TestRepositoriesClientPassager {
	
	@Autowired
	private ClientRepository clientRepository;
	
	@Autowired
	private PassagerRepository passagerRepository;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void test() {
		assertNotNull(clientRepository);
		assertNotNull(passagerRepository);

	}
	
	@Test
	public void testPassager() {
		Passager passager= new Passager();
	//	passager.setNom("Saidani");
	//	passagerRepository.save(passager);
		passagerRepository.deleteAll();
		assertTrue(passagerRepository.findAll().isEmpty());
	}
	
	@Test
	public void testClient() {
		Client client= new Client();
		client.setClientName("tanguy");
		clientRepository.save(client);
		
		assertFalse(clientRepository.findAll().isEmpty());
//		client.setNumeroTel(0475000000);;
//		clientRepository.save(client);
////		assertEquals("tanguy", adherentRepository.findById(100).get().getNom());
//
	}

}
