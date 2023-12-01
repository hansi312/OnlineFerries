package Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
public class Cabin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String description;

    private int passengers;

    @OneToMany(mappedBy = "cabin",cascade = CascadeType.PERSIST)
    List<ShipCabin> shipCabins = new ArrayList<>();

    public Cabin() {
    }
}