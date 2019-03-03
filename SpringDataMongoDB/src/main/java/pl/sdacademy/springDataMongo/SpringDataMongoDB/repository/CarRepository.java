package pl.sdacademy.springDataMongo.SpringDataMongoDB.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import pl.sdacademy.springDataMongo.SpringDataMongoDB.model.Car;

import java.util.List;

public interface CarRepository extends MongoRepository <Car, Long> {

    List<Car> findByBrand(@Param("brand") String brand);
}
