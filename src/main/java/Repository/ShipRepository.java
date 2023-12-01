package Repository;

import Entity.Cabin;
import Entity.Route;
import Entity.Ship;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ShipRepository extends JpaRepository<Ship,Integer> {
    List<Ship> findShipByDescription(String name);

    List<Ship> findShipByPassengersGreaterThan(int passengers);

    @Query("select ship from Ship ship where ship.shipCabin =?1")
    List<Ship> findShipByCabinId(Optional<Cabin> cabin);

    List<Ship> findShipByCarsGreaterThanEqualAndPassengersGreaterThanEqual(int cars, int passengers);

}
