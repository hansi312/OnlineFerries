package Service;

import Dao.ShipCabinDAO;
import Entity.*;
import Repository.CabinRepostitory;
import Repository.RouteRepository;
import Repository.ShipRepository;
import Repository.TripRepository;
import org.hibernate.annotations.NaturalId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CabinService {
    @Autowired
    CabinRepostitory cabinRepository;
    @Autowired
    TripRepository tripRepository;
    @Autowired
    RouteRepository routeRepository;
    @Autowired
    ShipRepository shipRepository;


    public Cabin persistCabin(Cabin cabin){
        return cabinRepository.save(cabin);
    }

    public List<ShipCabinDAO> findShipCabins(Integer tripId) {
        Trip t = tripRepository.findById(tripId).isPresent()? tripRepository.findById(tripId).get():null;
        Route route = routeRepository.findById(t.getRoute().getId()).isPresent()?routeRepository.findById(t.getRoute().getId()).get():null;
        Ship s = shipRepository.findById(route.getShip().getId()).isPresent()?shipRepository.findById(route.getShip().getId()).get():null;
        List<ShipCabin> shipCabins = s.getShipCabin();
        List <ShipCabinDAO> shipCabinDAOS = new ArrayList<>();
        for (ShipCabin shipcabin:shipCabins
             ) {
             shipCabinDAOS.add(new ShipCabinDAO(s.getId(),
                     shipcabin.getCabin().getId(),
                     shipcabin.getCabin().getDescription(),
                     shipcabin.getCabin().getPassengers(),
                     shipcabin.getCount(),
                     shipcabin.getPrice(),
                     1));
        }
        return shipCabinDAOS;
    }
}
