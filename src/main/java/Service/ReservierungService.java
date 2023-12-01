package Service;

import Entity.Reservierung;
import Repository.ReservierungRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import Exception.NotException;

import java.util.Optional;

@Service
public class ReservierungService {
    @Autowired
    ReservierungRepository reservierungRepository;

    public Reservierung getReservierungById(Integer reservationId) {
        Optional<Reservierung> r = reservierungRepository.findById(reservationId);
        if(r.isEmpty())throw new NotException("Reservation with ID: "+reservationId+" not found");
        return r.get();
    }

    public Reservierung persistReservierung(Reservierung reservierung) {
        return reservierungRepository.save(reservierung);
    }

    public Reservierung changeReservierung(Reservierung reservierung) {
        Optional <Reservierung> r = reservierungRepository.findById(reservierung.getId());
        if(r.isEmpty())throw new NotException("Reservierung with ID: "+reservierung.getId()+" not found");
        return reservierungRepository.save(reservierung);
    }
}
