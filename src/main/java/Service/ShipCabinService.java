package Service;

import Entity.Cabin;
import Entity.Ship;
import Repository.CabinRepostitory;
import Repository.ShipCabinRepository;
import Repository.ShipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLOutput;
import java.util.List;

@Service
public class ShipCabinService {
    @Autowired
    ShipCabinRepository shipCabinRepository;

    @Autowired
    ShipRepository shipRepository;

    @Autowired
    CabinRepostitory cabinRepostitory;



    public double getShipCabinPrice(Integer cabinId, Integer shipId) {
        Ship ship = shipRepository.findById(shipId).get();
        System.out.println(ship);
        Cabin cabin = cabinRepostitory.findById(cabinId).get();
        System.out.println(cabin);
        return shipCabinRepository.getById(cabin, ship).getPrice();
    }
}
