package Controller;


import Dao.ShipCabinDAO;
import Entity.Cabin;
import Service.CabinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CabinController {
    @Autowired
    CabinService cabinService;

    @PostMapping("/cabin")
    public Cabin postCabin(@RequestBody Cabin cabin){
        return cabinService.persistCabin(cabin);
    }

    @GetMapping("/OnlineFerries/cabins/trip/{tripId}")
    public List<ShipCabinDAO> findShipCabins(@PathVariable Integer tripId){
        return cabinService.findShipCabins(tripId);
    }


}
