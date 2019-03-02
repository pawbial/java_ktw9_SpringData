package pl.sdacademy.springdata.SpringDataJDBC.repository;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import pl.sdacademy.springdata.SpringDataJDBC.music.Album;

public interface MusicRepositoryConfiguration extends CrudRepository <Album, Long> {

    @Query("SELECT count (*) from SONG")
    int countSongs ();
}
