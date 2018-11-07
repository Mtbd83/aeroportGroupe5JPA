package repositories;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import model.Aeroport;
import model.Compagnie;
import model.CompagnieVol;
import model.CompagnieVolKey;
import model.Escale;
import model.EscaleKey;
import model.Ville;
import model.VilleAeroport;
import model.VilleAeroportKey;
import model.Vol;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/applicationContext.xml" })
public class TestClement {

	@Autowired
	private CompagnieVolRepository compagnieVolRepository;

	@Autowired
	private VilleAeroportRepository villeAeroportRepository;

	@Autowired
	private EscaleRepository escaleRepository;

	@Test
	public void test() {
		assertNotNull(compagnieVolRepository);
		assertNotNull(villeAeroportRepository);
		assertNotNull(escaleRepository);

		Compagnie compagnie = new Compagnie();
		compagnie.setIdCompagnie(3);
		compagnie.setNom("American Airlines");
		compagnie.setVersion(1);
		Vol vol = new Vol();
		vol.setIdVol(3);
		vol.setVersion(1);
		Ville ville = new Ville();
		ville.setIdVille(4);
		ville.setNom("NY");
		ville.setVersion(1);
		Aeroport aeroport = new Aeroport();
		aeroport.setIdAeroport(30);
		aeroport.setNom("JFK");
		aeroport.setVersion(1);

		CompagnieVolKey compagnieVolKey = new CompagnieVolKey();
		compagnieVolKey.setCompagnie(compagnie);
		compagnieVolKey.setVol(vol);
		CompagnieVol compagnieVol = new CompagnieVol();
		compagnieVol.setKey(compagnieVolKey);

		VilleAeroportKey villeAeroportKey = new VilleAeroportKey();
		villeAeroportKey.setVille(ville);
		villeAeroportKey.setAeroport(aeroport);
		VilleAeroport villeAeroport = new VilleAeroport();
		villeAeroport.setKey(villeAeroportKey);

		EscaleKey escaleKey = new EscaleKey();
		escaleKey.setVol(vol);
		escaleKey.setAeroport(aeroport);
		Escale escale = new Escale();
		escale.setKey(escaleKey);
		
//		compagnieVolRepository.save(compagnieVol);
//		System.out.println(compagnieVolRepository.findById(compagnieVolKey).get().getKey().getCompagnie().getNom());
	}
}
