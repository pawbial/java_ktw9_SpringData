package pl.sdacademy.springdatajpa.SpringDataJPA.model;


import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;




@Data
@Entity
@Table (name = "PLAYERS")
public class Player {


    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    Long id;
    @Column (name = "FIRST_NAME")
    String firstName;
    @Column (name = "LAST_NAME")
    String lastName;
    @Column (name = "AGE")
    Integer age;
    @Column (name = "ROLE")
    Role role;

    public Player () {

    }

}
