package Repository;

import Entity.Route;
import Entity.Trip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface TripRepository extends JpaRepository<Trip, Integer> {

    List<Trip> findTripByRouteIs(Route route);

    @Query("select trip from Trip trip where YEAR(trip.departure) =?1")
    List<Trip> findTripByDeparture(int year);
}
