package repositories;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import model.Aeroport;
import model.Compagnie;
import model.Ville;
import service.CompagnieService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/applicationContext.xml" })
public class TestTanguy {

	@Autowired
	private AeroportRepository aeroportRepository;

	@Autowired
	private CompagnieRepository compagnieRepository;

	@Autowired
	private VilleRepository villeRepository;

	@Autowired
	private CompagnieService compagnieService;

	@Test
	public void test() {
//		assertNotNull(aeroportRepository);

//		Aeroport aeroport = new Aeroport();
//		aeroport.setNom("orly");
//		aeroportRepository.save(aeroport);
//		System.out.println(aeroportRepository.findAll());
//		System.out.println(aeroportRepository.findById(21).get().getNom());

//		Aeroport aeroport = new Aeroport();
//		aeroport = aeroportRepository.findById(21).get();
//		aeroport.setNom("cdg");
//		aeroportRepository.save(aeroport);
//		assertEquals("cdg", aeroportRepository.findById(21).get().getNom());

		assertNotNull(compagnieService);
		Compagnie compagnie = new Compagnie();
		compagnie.setNom("air_france");

//		compagnieService.createCompagnie(compagnie);
		compagnieService.deleteCompagnie(compagnie);
		System.out.println(compagnieService.findAllCompagnies());
		assertEquals("air_france", compagnieService.findCompagnieByName("air_france").getNom());

	}

}
