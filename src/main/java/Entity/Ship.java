package Entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Ship {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    private String description;

    private int passengers;

    private int cars;

    @OneToMany(mappedBy = "cabin",cascade = CascadeType.PERSIST)
    List<ShipCabin> shipCabin = new ArrayList<>();

    @OneToMany(mappedBy = "ship", cascade = CascadeType.PERSIST)
    List<Route> routen = new ArrayList<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPassengers() {
        return passengers;
    }

    public void setPassengers(int passengers) {
        this.passengers = passengers;
    }

    public int getCars() {
        return cars;
    }

    public void setCars(int cars) {
        this.cars = cars;
    }

    public List<ShipCabin> getShipCabin() {
        return shipCabin;
    }

    public void addShipCabin(ShipCabin shipCabin) {
        this.shipCabin.add(shipCabin) ;
    }
}
