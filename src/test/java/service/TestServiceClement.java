package service;

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
import repositories.AeroportRepository;
import repositories.CompagnieRepository;
import repositories.CompagnieVolRepository;
import repositories.EscaleRepository;
import repositories.VilleAeroportRepository;
import repositories.VilleRepository;
import repositories.VolRepository;
import service.CompagnieVolService;
import service.EscaleService;
import service.VilleAeroportService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/applicationContext.xml" })
public class TestServiceClement {

	@Autowired
	private CompagnieRepository compagnieRepository;
	@Autowired
	private VolRepository volRepository;
	@Autowired
	private VilleRepository villeRepository;
	@Autowired
	private AeroportRepository aeroportRepository;
	@Autowired
	private CompagnieVolRepository compagnieVolRepository;
	@Autowired
	private VilleAeroportRepository villeAeroportRepository;
	@Autowired
	private EscaleRepository escaleRepository;
	@Autowired
	private CompagnieVolService compagnieVolService;
	@Autowired
	private VilleAeroportService villeAeroportService;
	@Autowired
	private EscaleService escaleService;

	@Test
	public void test() {
		assertNotNull(compagnieVolRepository);
		assertNotNull(villeAeroportRepository);
		assertNotNull(escaleRepository);
		assertNotNull(compagnieVolService);
		assertNotNull(villeAeroportService);
		assertNotNull(escaleService);

		Compagnie compagnie = new Compagnie();
		compagnie.setNom("American Airlines");
		compagnieRepository.save(compagnie);
		Vol vol = new Vol();
		volRepository.save(vol);
		Ville ville = new Ville();
		ville.setNom("NY");
		villeRepository.save(ville);
		Aeroport aeroport = new Aeroport();
		aeroport.setNom("JFK");
		aeroportRepository.save(aeroport);		

		CompagnieVolKey compagnieVolKey = new CompagnieVolKey();
		compagnieVolKey.setCompagnie(compagnie);
		compagnieVolKey.setVol(vol);
		CompagnieVol compagnieVol = new CompagnieVol();
		compagnieVol.setKey(compagnieVolKey);
		compagnieVolRepository.save(compagnieVol);

		compagnieVolService.createCompagnieVol(compagnie, vol);
		compagnieVolService.updateCompagnie(compagnieVol, compagnie);
		compagnieVolService.updateVol(compagnieVol, vol);
		compagnieVolService.deleteCompagnieVol(compagnieVol);

		VilleAeroportKey villeAeroportKey = new VilleAeroportKey();
		villeAeroportKey.setVille(ville);
		villeAeroportKey.setAeroport(aeroport);
		VilleAeroport villeAeroport = new VilleAeroport();
		villeAeroport.setKey(villeAeroportKey);
		villeAeroportRepository.save(villeAeroport);

		villeAeroportService.createVilleAeroport(ville, aeroport);
		villeAeroportService.updateVille(villeAeroport, ville);
		villeAeroportService.updateAeroport(villeAeroport, aeroport);
		villeAeroportService.deleteVilleAeroport(villeAeroport);

		EscaleKey escaleKey = new EscaleKey();
		escaleKey.setVol(vol);
		escaleKey.setAeroport(aeroport);
		Escale escale = new Escale();
		escale.setKey(escaleKey);
		escaleRepository.save(escale);

		escaleService.createEscale(vol, aeroport);
		escaleService.updateVol(escale, vol);
		escaleService.updateAeroport(escale, aeroport);
		escaleService.deleteEscale(escale);
	}
}
