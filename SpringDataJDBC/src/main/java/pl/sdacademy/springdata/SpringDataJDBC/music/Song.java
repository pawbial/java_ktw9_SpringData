package pl.sdacademy.springdata.SpringDataJDBC.music;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
@Builder
public class Song {

    @Id
    private Long id;
    private String title;
    private Integer durationInSec;
    Album album;
    Integer albumKey;
}
