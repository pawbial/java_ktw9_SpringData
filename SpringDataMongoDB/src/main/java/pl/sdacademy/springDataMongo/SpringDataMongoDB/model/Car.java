package pl.sdacademy.springDataMongo.SpringDataMongoDB.model;


import com.sun.xml.internal.bind.v2.TODO;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
public class Car {

    private Long id;
    private String brand;
    private String model;
    private Integer capacity;
    private Integer hp;
    private Double vMax;


}
