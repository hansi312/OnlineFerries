package Controller;

import Entity.Route;
import Service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RouteController {
    @Autowired
    RouteService routeService;

    @GetMapping("/routes")
    public List<Route> getAll(){
        return routeService.getAll();
    }

    @GetMapping("/routes/ship/{shipId}")
    public List<Route> getRoutesFromShip(@PathVariable Integer shipId){
        return routeService.getRoutesFromShip(shipId);
    }

}
