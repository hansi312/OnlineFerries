package Repository;

import Entity.Cabin;
import Entity.Ship;
import Entity.ShipCabin;
import Entity.ShipCabinId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ShipCabinRepository extends JpaRepository<ShipCabin, ShipCabinId> {
    @Query("select shipcabin from ShipCabin shipcabin where shipcabin.cabin =?1 and shipcabin.ship =?2 ")
    ShipCabin getById(Cabin cabin, Ship ship);
}
