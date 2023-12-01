package Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@IdClass(ShipCabinId.class)
@Getter
@Setter
public class ShipCabin  {
    @JsonIgnore
    @Id
    @ManyToOne(optional = false)
    @JoinColumn(name = "ship_id", nullable = false)
    private Ship ship;
    @JsonIgnore
    @Id
    @ManyToOne(optional = false)
    @JoinColumn(name = "cabin_id", nullable = false)
    private Cabin cabin;

    private int count;
    private double price;
    
}
