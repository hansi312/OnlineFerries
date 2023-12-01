package Dao;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ShipCabinDAO {
    private Integer ship_id;
    private Integer cabin_id;

    private String cabinDescription;
    private int passengers; // max. Belegung der Kabine
    private int count; // Anzahl der Kabinen dieses Typs
    // auf dem Schiff (aus der Tabelle
    // ShipCabin)
    private double price; // Preis der Kabine auf dem Schiff
    // (aus der Tabelle ShipCabin)
    private int reservation_count; // wird für eines Reservierungs-
    // vorgang benötigt.


    public ShipCabinDAO(){}
    public ShipCabinDAO(Integer ship_id, Integer cabin_id, String cabinDescription, int passengers, int count, double price, int reservation_count) {
        this.ship_id = ship_id;
        this.cabin_id = cabin_id;
        this.cabinDescription = cabinDescription;
        this.passengers = passengers;
        this.count = count;
        this.price = price;
        this.reservation_count = reservation_count;
    }
}
