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

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/applicationContext.xml" })
public class TestTanguy {

	@Autowired
	private AeroportRepository aeroportRepository;

	@Autowired
	private CompagnieRepository compagnieRepository;

	@Autowired
	private VilleRepository villeRepository;

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

//		assertNotNull(compagnieRepository);

//		Compagnie compagnie = new Compagnie();
//		compagnie.setNom("air_france");
//		compagnieRepository.save(compagnie);
//		System.out.println(compagnieRepository.findAll());
//		System.out.println(compagnieRepository.findById(5).get().getNom());

//		Compagnie compagnie = new Compagnie();
//		compagnie = compagnieRepository.findById(5).get();
//		compagnie.setNom("klm");
//		compagnieRepository.save(compagnie);
//		assertEquals("klm", compagnieRepository.findById(5).get().getNom());

		assertNotNull(villeRepository);

//		Ville ville = new Ville();
//		ville.setNom("lyon");
//		villeRepository.save(ville);
//		System.out.println(villeRepository.findAll());
//		System.out.println(villeRepository.findById(2).get().getNom());

		Ville ville = new Ville();
		ville = villeRepository.findById(2).get();
		ville.setNom("villeurbanne");
		villeRepository.save(ville);
		assertEquals("villeurbanne", villeRepository.findById(2).get().getNom());

	}

}
