package Controller;

import Entity.Ship;
import Service.ShipService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.awt.image.RescaleOp;
import java.util.List;
import java.util.Optional;

@RestController
public class ShipController {


    @Autowired
    ShipService shipService;

    @GetMapping("/ship")
    public List<Ship> getAll(){
        return shipService.getAll();
    }
    @GetMapping("/ship/{id}")
    public ResponseEntity<Ship> findOne(@PathVariable("id") Integer id){
        try{
            Ship s = shipService.findById(id);
            return ResponseEntity.status(HttpStatus.OK).body(s);
        }
        catch(NotFoundException notFoundException){
            HttpHeaders h1 = new HttpHeaders();
            h1.set("msg",notFoundException.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).headers(h1).body(null);
        }
        catch(Exception e){
            HttpHeaders h1 = new HttpHeaders();
            h1.set("msg",e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).headers(h1).body(null);
        }
    }
    @GetMapping("/ship/description/{description}")
    public List<Ship>findShipDescription(@PathVariable String description){
        return shipService.findShipByDescription(description);
    }

    @GetMapping("/ship/passengers/{passengers}")
    public List<Ship>findShipsWithMoreThanXPassengers(@PathVariable int passengers){
        return shipService.findShipByPassengersGreaterThan(passengers);
    }
    @GetMapping("/ship/cabin/{id}")
    public List<Ship>findShipWithCabin(@PathVariable Integer id){
        return shipService.findShipByShipCabinId(id);
    }

    @GetMapping("/ship/cars/{cars}/passengers/{passengers}")
    public List<Ship>findShipWithCarAndPassenger(@PathVariable int cars, @PathVariable int passengers)
    {
        return shipService.findShipWithCarAndPassenger(cars,passengers);
    }

    @GetMapping("/ship/{id}/passengers")
    public ResponseEntity<Integer> getPassengers(@PathVariable Integer id){
        try{
           Integer i =  shipService.findById(id).getPassengers();
           return ResponseEntity.status(HttpStatus.OK).body(i);
        }
        catch(NotFoundException nfe){
            HttpHeaders h1 = new HttpHeaders();
            h1.set("msg",nfe.getMessage());

            return ResponseEntity.status(HttpStatus.NOT_FOUND).headers(h1).body(null);
        }
        catch(Exception e){
            HttpHeaders h1 = new HttpHeaders();
            h1.set("msg", e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).headers(h1).body(null);
        }
    }
    @GetMapping("/ship/route/{routeId}")
    public Ship getShipByRoute(@PathVariable Integer routeId){
        return shipService.findShipByRout(routeId);
    }
}
