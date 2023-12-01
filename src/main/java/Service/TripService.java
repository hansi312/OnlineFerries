package Service;

import Entity.*;
import Repository.RouteRepository;
import Repository.TripRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TripService {
    @Autowired
    TripRepository tripRepository;

    @Autowired
    ShipService shipService;

    @Autowired
    RouteRepository routeRepository;

    @Autowired
    ShipCabinService shipCabinService;

    public List<Trip> getTripsFromRoute(Route route) {
        return tripRepository.findTripByRouteIs(route);
    }

    public List<Trip> getTripsInYear(int year) {
        return tripRepository.findTripByDeparture(year);
    }

    public List <Double> getPricesFromRouteId(Integer routeId) {
        Ship s = shipService.findShipByRout(routeId);
        List <ShipCabin> shipCabin = s.getShipCabin();
        List <Double> prices = new ArrayList<>();
        for (ShipCabin scabin:shipCabin
             ) {
            prices.add(scabin.getPrice());
        }
        return prices;
    }
}
