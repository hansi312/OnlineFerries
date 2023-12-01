package Controller;

import Service.ShipCabinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ShipCabinController {
    @Autowired
    ShipCabinService shipCabinService;

    @GetMapping("/shipcabin/price/cabin/{cabinId}/ship/{shipId}")
    public double getShipCabinPrice(@PathVariable Integer cabinId, @PathVariable Integer shipId){
        return shipCabinService.getShipCabinPrice(cabinId, shipId);
    }
}
