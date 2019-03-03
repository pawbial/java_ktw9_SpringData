package pl.sdacademy.springdatajpa.SpringDataJPA.model;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pl.sdacademy.springdatajpa.SpringDataJPA.repository.PlayerRepository;
import pl.sdacademy.springdatajpa.SpringDataJPA.repository.TeamRepository;


import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PlayerTest {

        @Autowired
        private PlayerRepository playerRepository;

        @Autowired
        private TeamRepository teamRepository;

        @Test
        public void shouldReturnTrueWhenFindById() {
            // Given
            Player player1 = new Player ();
            player1.setAge(12);
            player1.setFirstName("AA");
            player1.setLastName("BB");

            // When
            playerRepository.save(player1);


            Optional<Player> byId = playerRepository.findById(1L);
            boolean present = byId.isPresent();

            assertThat(present).isTrue();
        }

}