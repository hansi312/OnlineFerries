package Service;

import Entity.Cabin;
import Entity.Route;
import Entity.Ship;
import Entity.ShipCabin;
import Repository.CabinRepostitory;
import Repository.RouteRepository;
import Repository.ShipCabinRepository;
import Repository.ShipRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import Exception.NotException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ShipService {
    @Autowired()
    ShipRepository shipRepository;

    @Autowired
    CabinRepostitory cabinRepostitory;

    @Autowired
    ShipCabinRepository shipCabinRepository;

    @Autowired
    RouteRepository routeRepository;

    public List<Ship> getAll() {
        return shipRepository.findAll();
    }

    public Ship findById(Integer id) throws NotFoundException {
        Optional <Ship> ship = shipRepository.findById(id);
        if(ship.isEmpty())throw new NotFoundException("Schiff nicht gefunden mit id:"+id);
        return ship.get();
    }

    public List<Ship> findShipByDescription(String name) {
        return shipRepository.findShipByDescription(name);
    }

    public List<Ship> findShipByPassengersGreaterThan(int passengers) {
        return shipRepository.findShipByPassengersGreaterThan(passengers);
    }

    public List<Ship> findShipByShipCabinId(Integer id) {
        Optional<Cabin> c = cabinRepostitory.findById(id);
        if (c.isEmpty()) throw new NotException("Cabin not found");
        List<ShipCabin> sc = shipCabinRepository.findAll();
        if(sc.isEmpty())throw new NotException("ShipCabin not found");
        List<Ship> result = new ArrayList<>();
        for (ShipCabin shipcabin:sc
             ) {if(shipcabin.getCabin().getId() ==id){
                 result.add(shipcabin.getShip());
        }
        }
        return result;
    }

    public List<Ship> findShipWithCarAndPassenger(int cars, int passengers) {
        return shipRepository.findShipByCarsGreaterThanEqualAndPassengersGreaterThanEqual(cars,passengers);
    }

    public Ship findShipByRout(Integer routeId) {
        return routeRepository.findById(routeId).isPresent()? routeRepository.findById(routeId).get().getShip() : null;
    }
}
