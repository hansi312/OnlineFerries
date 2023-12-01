package Controller;

import Entity.Route;
import Entity.Trip;
import Service.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TripController {
    @Autowired
    TripService tripService;


    @PostMapping("/trip/route/{route}")
    public List<Trip> getTripsFromRoute(@RequestBody Route route){
        return tripService.getTripsFromRoute(route);
    }

    @GetMapping("/trip/year/{year}")
    public List<Trip> getTripsInYear(@PathVariable int year){
        return tripService.getTripsInYear(year);
    }

    @GetMapping("/trip/route/{routeId}")
    public List <Double> getPricesFromRouteId(@PathVariable Integer routeId){
        return tripService.getPricesFromRouteId(routeId);
    }
}
