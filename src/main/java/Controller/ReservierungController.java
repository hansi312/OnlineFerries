package Controller;

import Entity.Reservierung;
import Service.ReservierungService;
import io.swagger.models.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ReservierungController {
    @Autowired
    ReservierungService reservierungService;
    @GetMapping("/OnlineFerries/reservation/{reservationId}")
    public ResponseEntity <Reservierung> getReservierungById(@PathVariable Integer reservationId)
    {
        try{
            return ResponseEntity.status(HttpStatus.OK).body(reservierungService.getReservierungById(reservationId));
        }
        catch (Exception e){
            HttpHeaders h1 = new HttpHeaders();
            h1.set("msg",e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).headers(h1).body(null);
        }
    }
    @PostMapping("/OnlineFerries/reservation")
    public ResponseEntity <Reservierung> persistReservation(@RequestBody Reservierung reservierung){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(reservierungService.persistReservierung(reservierung));
        }
        catch(Exception e){
            HttpHeaders h1 = new HttpHeaders();
            h1.set("msg",e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).headers(h1).body(null);
        }
    }

    @PutMapping("/OnlineFerries/reservation")
    public ResponseEntity <Reservierung> changeReservation(@RequestBody Reservierung reservierung){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(reservierungService.changeReservierung(reservierung));
        }
        catch(Exception e){
            HttpHeaders h1 = new HttpHeaders();
            h1.set("msg",e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).headers(h1).body(null);
        }
    }
}
