package pl.sdacademy.springdata.SpringDataJDBC.person;


import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;

import java.time.LocalDate;

@Data
@Builder
public class Person {


    @Id
    private Long id;
    private String firstName;
    private String lastName;
    private Integer age;
    private LocalDate birthDate;
    private Proffesion proffesion;
}
