package Service;

import Entity.Route;
import Entity.Ship;
import Repository.RouteRepository;
import Repository.ShipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RouteService {

    @Autowired
    RouteRepository routeRepository;
    @Autowired
    ShipRepository shipRepository;
    public List<Route> getAll() {
        return routeRepository.findAll();
    }

    public List<Route> getRoutesFromShip(Integer shipId) {
        Ship s = shipRepository.findById(shipId).isPresent()?shipRepository.findById(shipId).get():null;
       return s ==null?null :routeRepository.findRouteByShipIs(s);
    }
}
