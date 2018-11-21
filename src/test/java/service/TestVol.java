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
import repositories.ReservationRepository;
import repositories.VolRepository;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"/applicationContext.xml"})
public class TestVol {

	@Autowired
	private VolService volService;
	@Autowired
	private VolRepository volRepository;

	


//	@Test
	public void testCreate() {
		Vol vol = new Vol();
		volRepository.save(vol);
		
		volService.createVol( vol);
		assertNotNull(volService.showAll());	
	}
	
//	@Test
	public void testDeleteAll() {
		volService.deleteAllVol();
		assertTrue(volService.showAll().isEmpty());
	}	
	
	
//	@Test
	public void testDelete() {
		volService.deleteVol(51);
		assertNull(volService.showVol(51));
	}
	
	
//	@Test
	public void testShowVol() {
		assertNotNull(volService.showVol(51));
	}
	
//	@Test
	public void testListResa() {
		assertNotNull(volService.showReservationByVol(51));
			
	}
	
	
//	@Test
	public void testListCompagnie() {
		assertNotNull(volService.showCompagniesByVol(51));
			
	}

	
	
	

}
