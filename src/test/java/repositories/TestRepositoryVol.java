package repositories;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import model.Vol;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"/applicationContext.xml"})
public class TestRepositoryVol {
	@Autowired
	private VolRepository volRepository;
	
	@Test
	public void test() {
		assertNotNull(volRepository);
	}
	
	//@Test
	public void testCreate() {
		Vol vol1= new Vol();
		volRepository.save(vol1);
		assertNotNull(volRepository.findAll());
	}
	
	
	//@Test
	public void testDelete() {
		volRepository.deleteAll();
		assertTrue((volRepository.findAll()).isEmpty());
	}

	@Test
	public void testFind() {
		Vol vol1= new Vol();
		volRepository.save(vol1);
		assertNotNull((volRepository.findById(50)));
	}
	
	
	
}
