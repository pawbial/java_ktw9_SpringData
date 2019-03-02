package pl.sdacademy.springdata.SpringDataJDBC.music;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.List;


@Data
@Builder
public class Album {

    @Id
    private Long id;
    private String title;
    private List<Song> songs;
}
