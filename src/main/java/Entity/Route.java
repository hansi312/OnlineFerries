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
@Table(name = "route")
public class Route {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    private String start;
    private String destination;

    @OneToMany(mappedBy = "route", cascade = CascadeType.PERSIST)
    List<Trip> trips = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "ship_id")
    @JsonIgnore
    private Ship ship;


}