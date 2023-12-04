package racingcar.model;

import racingcar.utill.RandomNumberGenerator;

import java.util.List;

public class Cars {

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void race() {
        for (Car car : cars) {
            car.tryMove(RandomNumberGenerator.generateRandomNumber());
        }
    }
}
