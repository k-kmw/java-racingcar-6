package racingcar.service;

import racingcar.model.Car;
import racingcar.model.Cars;

import java.util.List;

public class CarsService {
    public Cars createCars(List<Car> carList) {
        return new Cars(carList);
    }
}
