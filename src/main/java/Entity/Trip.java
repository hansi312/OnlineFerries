package Entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "trip")
@NoArgsConstructor
public class Trip {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    private Date date;
    private Date departure;
    private Date arrival;

    @ManyToOne()
    @JoinColumn(name = "route_id")
    private Route route;

    @OneToMany(mappedBy = "id")
    List<Reservierung> trips = new ArrayList<>();

}