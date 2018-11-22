package service;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import model.Client;
import model.Passager;
import model.Reservation;
import model.Vol;
import repositories.ClientRepository;
import repositories.PassagerRepository;
import repositories.VolRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/applicationContext.xml" })
public class TestReservation {

	@Autowired
	private ReservationService reservationService;
	@Autowired
	private ClientRepository clientRepository;
	@Autowired
	private PassagerRepository passagerRepository;
	@Autowired
	private VolRepository volRepository;

//	@Test
	public void test() {
		Client client = new Client();
		client.setClientName("Jean");
		clientRepository.save(client);
		Vol vol = new Vol();
		volRepository.save(vol);
		Passager passager = new Passager();
		passager.setNom("Jean");
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

	// @Test
	public void testDeleteByVol() {
		reservationService.deleteReservationByVol(50);
		assertTrue(reservationService.showReservationByVol(50).isEmpty());
	}

//	@Test
	public void showReservationByClient() {
		Optional<Client> client = clientRepository.findById(2);
		if (client.isPresent()) {
			reservationService.showReservationByClient(client.get());
		}
		assertNotNull(reservationService.showReservationByClient(client.get()));

	}

//	@Test
	public void showReservationByPassager() {
		Optional<Passager> passager = passagerRepository.findById(2);
		if (passager.isPresent()) {
			reservationService.showReservationByPassager(passager.get());
		}
		assertNotNull(reservationService.showReservationByPassager(passager.get()));

	}

//	@Test
	public void showReservationByClientName() {
		assertNotNull(reservationService.showReservationByNomClient("Jean"));

	}

//	@Test
	public void showReservationByPassagerName() {
		assertNotNull(reservationService.showReservationByNomPassager("Jean"));

	}

	@Test
	public void showReservationByPassagerId() {
		assertNotNull(reservationService.showReservationByIdPassager(2));
		List<Reservation> resas = reservationService.showReservationByIdPassager(2);
		for(Reservation resa : resas) {
			System.out.println("-------------------------");
			System.out.println(resa.getPassager().getPrenom());
			System.out.println("-------------------------");
		}
	}

}
