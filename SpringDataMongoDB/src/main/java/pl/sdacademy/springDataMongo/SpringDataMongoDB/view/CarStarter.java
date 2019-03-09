package pl.sdacademy.springDataMongo.SpringDataMongoDB.view;

import com.sun.xml.internal.bind.v2.TODO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import pl.sdacademy.springDataMongo.SpringDataMongoDB.model.Car;
import pl.sdacademy.springDataMongo.SpringDataMongoDB.repository.CarRepository;

@Component
public class CarStarter implements CommandLineRunner {

    private final static Logger LOGGER = LoggerFactory.getLogger(CarStarter.class);

    @Autowired
    private CarRepository carRepository;

    @Override
    public void run(String... args) throws Exception {


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
        carRepository.save(car2);
        carRepository.save(car3);
        LOGGER.info("Added 3 new Car type objects to dataBase");

    }
}
