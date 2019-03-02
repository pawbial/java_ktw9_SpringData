package pl.sdacademy.springdata.SpringDataJDBC.repository;

import org.springframework.data.repository.CrudRepository;
import pl.sdacademy.springdata.SpringDataJDBC.person.Person;



public interface PersonRepositoryConfiguration extends CrudRepository <Person, Long> {


}
