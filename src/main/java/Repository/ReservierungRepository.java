package Repository;

import Entity.Reservierung;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservierungRepository extends JpaRepository<Reservierung, Integer> {
}
