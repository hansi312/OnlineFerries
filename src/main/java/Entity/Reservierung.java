package Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Reservierung {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "Passenger")
    List <Passenger> passengers = new ArrayList<>();

    @ManyToOne(cascade = CascadeType.PERSIST)
    Trip trip;




}
