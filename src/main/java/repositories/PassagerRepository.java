package repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import model.Passager;
import model.Reservation;

public interface PassagerRepository extends JpaRepository<Passager, Integer>{
	
	Passager findByNom(String name);
	
	@Query("select p from Passager p left join fetch Reservation r where r.idPassager=:passager")
	
	List<Reservation> getReservatiosnParPassager(@Param("passager") Integer id);
	
//	List<Passager> findByReservation(Reservation reservation);

}
