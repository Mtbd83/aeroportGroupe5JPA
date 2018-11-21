package service;

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
public class TestServiceTanguy {

	@Autowired
	private CompagnieService compagnieService;

	@Autowired
	private AeroportService aeroportService;

	@Autowired
	private VilleService villeService;

	@Test
	public void test() {

//		assertNotNull(compagnieService);
//		Compagnie compagnie = new Compagnie();
//		compagnie.setNom("air_france");

//		compagnieService.createCompagnie(compagnie);
//		compagnieService.deleteCompagnie(compagnie);
//		assertNull(compagnieService.findCompagnieByName("air_france"));
//		System.out.println(compagnieService.findAllCompagnies());

//		compagnieService.updateCompagnieName(compagnie, "klm");

//		assertNotNull(aeroportService);
//		Aeroport aeroport = new Aeroport();
//		aeroport.setNom("orly");

//		aeroportService.createAeroport(aeroport);
//		assertEquals("orly", aeroportService.findAeroportByName(aeroport.getNom()).getNom());
//		aeroportService.deleteAeroport(aeroport);
//		assertNull(aeroportService.findAeroportByName("orly"));
//		aeroportService.updateAeroport(aeroport, "cdg");
//		assertEquals("cdg", aeroportService.findAeroportByName("cdg").getNom());

		Ville ville = new Ville();
		ville.setNom("paris");

		villeService.createVille(ville);
//		villeService.deleteVille(ville);
//		assertEquals("orly", aeroportService.findAeroportByName(aeroport.getNom()).getNom());
//		aeroportService.deleteAeroport(aeroport);
//		assertNull(aeroportService.findAeroportByName("orly"));
		villeService.updateVille(ville, "lyon");
//		assertEquals("cdg", aeroportService.findAeroportByName("cdg").getNom());

	}

}
