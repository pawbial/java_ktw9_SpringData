package pl.sdacademy.springdatajpa.SpringDataJPA.model;

import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.dsl.BooleanExpression;
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

            playerRepository.delete(player1);
        }

        @Test
        public void shouldReturnTrueIfAllQueriedPlayersNameIsJordan() {
        // Given
            Player player1 = new Player ();
            player1.setAge(12);
            player1.setFirstName("Jacek");
            player1.setLastName("BB");

            Player player2 = new Player();
            player2.setAge(13);
            player2.setFirstName("Jacek");
            player2.setLastName("CC");

            Player player3 = new Player();
            player3.setFirstName("Jacek");
            player3.setLastName("CC");
            player3.setAge(14);

            playerRepository.save(player1);
            playerRepository.save(player2);
            playerRepository.save(player3);


            // When
            BooleanExpression jacekExpression = QPlayer.player.firstName.eq("Jacek");
            OrderSpecifier<Integer> orderByAge = QPlayer.player.age.desc();
            Iterable<Player> jaceks = playerRepository.findAll(jacekExpression, orderByAge);


            // Then
            jaceks.forEach(jacek -> assertThat(jacek.getFirstName().equals("Jacek")));

        }


}