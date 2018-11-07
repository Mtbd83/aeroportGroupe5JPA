package service;

import static org.junit.Assert.*;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import model.Client;
import model.Passager;
import model.Vol;
import repositories.ClientRepository;
import repositories.PassagerRepository;
import repositories.VolRepository;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"/applicationContext.xml"})
public class TestReservation {

	@Autowired
	private ReservationService reservationService;
	@Autowired
	private ClientRepository clientRepository;
	@Autowired
	private PassagerRepository passagerRepository;
	@Autowired
	private VolRepository volRepository;
	


	@Test
	public void test() {
		Client client = new Client();
		clientRepository.save(client);
		Vol vol = new Vol();
		volRepository.save(vol);
		Passager passager = new Passager();
		passagerRepository.save(passager);
		
		reservationService.createReservation(client, passager, vol);
		assertNotNull(reservationService.showAll());	
	}
	
	
//	@Test
	public void testDelete() {
		reservationService.deleteReservation(50);
		assertTrue(reservationService.showAll().isEmpty());
	}
	
	
//	@Test
	public void testShowResa() {
		assertNotNull(reservationService.showReservation(50));
	}
	

	//@Test
	public void testDeleteByVol() {
		reservationService.deleteReservationByVol(50);
		assertTrue(reservationService.showReservationByVol(50).isEmpty());
	}

	
//	@Test
//	public void showReservationByClient() {
//		Optional<Client> client =clientRepository.findById(50) ;
//		if (client.isPresent()) {
//			reservationService.showReservationByClient(client.get());
//		}
//		assertNotNull(reservationService.showReservationByClient(client.get()));
//		
//	}
	
	

}
