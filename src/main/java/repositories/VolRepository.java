package repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import model.Vol;

public interface VolRepository extends JpaRepository<Vol, Integer>  {
	
	List<Vol> findByDateDepart(Date dateDepart);
	List<Vol> findByDateArrivee(Date dateArrivee);
	
	List<Vol> findByHeureDepartBetween (Date heureDepart1, Date heureDepart2 );
	List<Vol> findByHeureArriveeBetween (Date heureArivee1, Date heureArrivee2 );
	
}
