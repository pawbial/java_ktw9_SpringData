package pl.sdacademy.springdatajpa.SpringDataJPA.model;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pl.sdacademy.springdatajpa.SpringDataJPA.repository.PlayerRepository;
import pl.sdacademy.springdatajpa.SpringDataJPA.repository.TeamRepository;

import java.util.HashSet;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TeamTest {

    @Autowired
    private PlayerRepository playerRepository;

    @Autowired
    private TeamRepository teamRepository;

    @Test
    public void shouldReturn() {
    // Given
        Player player1 = new Player ();
        player1.setAge(12);
        player1.setFirstName("AA");
        player1.setLastName("BB");

        Player player2 = new Player ();
        player1.setAge(13);
        player1.setFirstName("AA");
        player1.setLastName("BB");

        Player player3 = new Player ();
        player1.setAge(14);
        player1.setFirstName("AA");
        player1.setLastName("BB");

        playerRepository.save(player1);
        playerRepository.save(player2);
        playerRepository.save(player3);

        HashSet<Player> players = new HashSet<>();
        players.add(player1);
        players.add(player2);
        players.add(player3);

        Team team = new Team();
        team.setName("ABC");
        team.setPlayers(players);

        teamRepository.save(team);
        // When

        long teamCount = teamRepository.count();
        long playerCount = playerRepository.count();

        // Then
        assertThat(teamCount).isEqualTo(1L);
        assertThat(playerCount).isEqualTo(3L);
    }


}