package pl.sdacademy.springdata.SpringDataJDBC.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import pl.sdacademy.springdata.SpringDataJDBC.configuration.PersonDataBaseConfiguration;
import pl.sdacademy.springdata.SpringDataJDBC.person.Person;
import pl.sdacademy.springdata.SpringDataJDBC.person.Proffesion;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.Assert.*;


@RunWith(SpringRunner.class)
@Transactional
@ContextConfiguration(classes = PersonDataBaseConfiguration.class)
@SpringBootTest
public class PersonRepositoryConfigurationTest {

    @Autowired
    PersonRepositoryConfiguration personRepository;

    @Test
    public void shouldReturn() {
        // Given
        Person person = Person.builder()
                .age(12)
                .firstName("aaa")
                .lastName("bbb")
                .proffesion(Proffesion.CONTROLLER)
                .build();

        // When
        personRepository.save(person);

        boolean result = personRepository.existsById(1L);

        Optional<Person> byId = personRepository.findById(1L);
        boolean present = byId.isPresent();
        Person person1 = byId.get();


        // Then
        assertThat(result).isTrue();
        assertThat(present).isTrue();
        assertThat(person1.getFirstName().equals("aaa"));
        assertThat(person1.getProffesion().equals(Proffesion.CONTROLLER));
    }


    public static void main(String[] args) {


    }
}
