package Entity;

import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter
public class ShipCabinId implements Serializable {
//    @Serial
//    private static final long serialVersionUID = 1L;
    private int ship;
    private int cabin;

    public ShipCabinId() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ShipCabinId that = (ShipCabinId) o;

        if (ship != that.ship) return false;
        return cabin == that.cabin;
    }

    @Override
    public int hashCode() {
        int result = ship;
        result = 31 * result + cabin;
        return result;
    }
}
