package repositories;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import model.Reservation;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"/applicationContext.xml"})
public class TestRepositoryReservation {

	@Autowired
	private ReservationRepository reservationRepository;

	@Test
	public void test() {
		assertNotNull(reservationRepository);
	}
	
	@Test
	public void testCreate() {
		Reservation resa1= new Reservation();
		reservationRepository.save(resa1);
		assertNotNull(reservationRepository.findAll());
	}
	
	
	@Test
	public void testDelete() {
		reservationRepository.deleteAll();
		assertTrue((reservationRepository.findAll()).isEmpty());
	}

	@Test
	public void testFind() {
		assertNotNull(((reservationRepository.findById(51)).get().getNumeroReservation()));
	}
	
}
