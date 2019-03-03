package pl.sdacademy.springdatajpa.SpringDataJPA.model;


import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
public class Team {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @OneToMany (cascade = CascadeType.REMOVE)
    private Set<Player> players;
}
