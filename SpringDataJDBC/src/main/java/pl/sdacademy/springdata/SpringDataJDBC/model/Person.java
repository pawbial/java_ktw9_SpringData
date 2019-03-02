package pl.sdacademy.springdata.SpringDataJDBC.model;


import com.sun.javafx.beans.IDProperty;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;

import java.sql.Date;

@Data
@Builder
public class Person {


    @Id
    private Long id;
    private String firstName;
    private String lastName;
    private Integer age;
    private Date birthDate;
    private Proffesion proffesion;
}
