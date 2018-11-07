package service;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import model.Client;
import repositories.ClientRepository;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/applicationContext.xml"})
public class TestClientService {
	
	@Autowired
	private ClientService clientService;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void test() {
	//	Client client= new Client();
	//	client.setClientName("Tanguy");
	//	clientService.createClient(client);
		
	//	clientService.modifyClientName(client, "Tanguette");
		clientService.deleteClientByName("Tanguette");
		clientService.deleteClientByName("Tanguy");
		clientService.deleteClientByName("tanguy");


		
		

	}

}
