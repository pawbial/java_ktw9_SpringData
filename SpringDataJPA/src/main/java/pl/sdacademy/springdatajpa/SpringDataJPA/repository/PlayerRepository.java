package pl.sdacademy.springdatajpa.SpringDataJPA.repository;

import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;
import pl.sdacademy.springdatajpa.SpringDataJPA.model.Player;

public interface PlayerRepository extends CrudRepository <Player, Long>, QuerydslPredicateExecutor <Player> {

}
