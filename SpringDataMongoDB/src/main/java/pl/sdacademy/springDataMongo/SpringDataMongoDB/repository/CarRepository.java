package pl.sdacademy.springDataMongo.SpringDataMongoDB.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import pl.sdacademy.springDataMongo.SpringDataMongoDB.model.Car;

public interface CarRepository extends MongoRepository <Car, Long> {
}
