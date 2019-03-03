package pl.sdacademy.springdatajpa.SpringDataJPA.repository;

import org.springframework.data.repository.CrudRepository;
import pl.sdacademy.springdatajpa.SpringDataJPA.model.Team;

public interface TeamRepository extends CrudRepository <Team, Long> {

}
