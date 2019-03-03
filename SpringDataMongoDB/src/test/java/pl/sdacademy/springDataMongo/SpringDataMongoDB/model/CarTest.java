package pl.sdacademy.springDataMongo.SpringDataMongoDB.model;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.test.context.junit4.SpringRunner;
import pl.sdacademy.springDataMongo.SpringDataMongoDB.repository.CarRepository;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
@SpringBootTest
public class CarTest {

    @Autowired
    private CarRepository carRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    @Test
    public void shouldReturnTrueWhenCountingDBSizeAfterSaveAndDelete() {
        // Given
        Car car1 = new Car();
        car1.setBrand("VW");
        car1.setCapacity(1895);
        car1.setHp(105);
        car1.setVMax(200D);
        car1.setModel("1");
        car1.setId(1L);

        Car car2 = new Car();
        car2.setBrand("Toyota");
        car2.setCapacity(2240);
        car2.setHp(150);
        car2.setVMax(200D);
        car2.setModel("2");
        car2.setId(2L);

        Car car3 = new Car();
        car3.setBrand("Ford");
        car3.setCapacity(1980);
        car3.setHp(130);
        car3.setVMax(200D);
        car3.setModel("3");
        car3.setId(3L);

        carRepository.save(car1);
        carRepository.save(car3);
        carRepository.save(car2);
        // When
        long count1 = carRepository.count();
        Optional<Car> byId = carRepository.findById(3L);
        String brand = byId.get().getBrand();
        carRepository.delete(car1);
        long count2 = carRepository.count();
        // Then
        assertThat(count1).isEqualTo(3L);
        assertThat(brand).isEqualTo("Ford");
        assertThat(count2).isEqualTo(2L);
    }

    @Test
    public void shouldReturnTrueWhenCountingDBSizeAfterSavingAndDeletingFromMongoTemplate() {
        // Given
        mongoTemplate.dropCollection(Car.class);

        Car car1 = new Car();
        car1.setBrand("VW");
        car1.setCapacity(1895);
        car1.setHp(105);
        car1.setVMax(200D);
        car1.setModel("1");
        car1.setId(1L);

        Car car2 = new Car();
        car2.setBrand("Toyota");
        car2.setCapacity(2240);
        car2.setHp(150);
        car2.setVMax(200D);
        car2.setModel("2");
        car2.setId(2L);

        Car car3 = new Car();
        car3.setBrand("Ford");
        car3.setCapacity(1980);
        car3.setHp(130);
        car3.setVMax(200D);
        car3.setModel("3");
        car3.setId(3L);

        mongoTemplate.save(car1);
        mongoTemplate.save(car2);
        mongoTemplate.save(car3);
        // When
        Query query = new Query();
        Query model = query.addCriteria(Criteria.where("model").is("3"));
        List<Car> carsQuery = mongoTemplate.find(model, Car.class);

        List<Car> allCars = mongoTemplate.findAll(Car.class);
        int size = allCars.size();
        // Then
        assertThat(size).isEqualTo(3L);
        assertThat(carsQuery.size()).isEqualTo(1);
    }

    @Test
    public void shouldReturn2WhenExecutingGivenQuerry() {
        // Given
        mongoTemplate.dropCollection(Car.class);

        Car car1 = new Car();
        car1.setBrand("VW");
        car1.setCapacity(1895);
        car1.setHp(105);
        car1.setVMax(200D);
        car1.setModel("1");
        car1.setId(1L);

        Car car2 = new Car();
        car2.setBrand("Toyota");
        car2.setCapacity(2240);
        car2.setHp(150);
        car2.setVMax(200D);
        car2.setModel("2");
        car2.setId(2L);

        Car car3 = new Car();
        car3.setBrand("Ford");
        car3.setCapacity(1980);
        car3.setHp(130);
        car3.setVMax(200D);
        car3.setModel("3");
        car3.setId(3L);

        mongoTemplate.save(car1);
        mongoTemplate.save(car2);
        mongoTemplate.save(car3);
        // When
        Query query = new Query();
        Query model = query.addCriteria(Criteria.where("hp").gte(130));
        List<Car> cars = mongoTemplate.find(model, Car.class);

        model.addCriteria(Criteria.where("brand").is("Toyota"));
        List<Car> cars1 = mongoTemplate.find(model, Car.class);
        // Then
        assertThat(cars.size()).isEqualTo(2);
        assertThat(cars1.size()).isEqualTo(1);
        assertThat(mongoTemplate.find(model,Car.class).size()).isEqualTo(1);

    }


}