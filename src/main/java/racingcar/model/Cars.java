package racingcar.model;

import racingcar.utill.RandomNumberGenerator;

import java.util.Collections;
import java.util.List;

public class Cars {

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        validateCarsSize(cars);
        validateCarName(cars);
        this.cars = cars;
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }

    public void race() {
        for (Car car : cars) {
            car.tryMove(RandomNumberGenerator.generateRandomNumber());
        }
    }

    private void validateCarsSize(List<Car> cars) {
        if(cars.size() < 2) {
            throw new IllegalArgumentException("[Error] 자동차는 최소 2대를 입력해야 합니다.");
        }
    }

    private void validateCarName(List<Car> cars) {
        for (Car car : cars) {
            if (car.getName().length() > 5) {
                throw new IllegalArgumentException("[Error] 자동차의 이름은 5자리를 초과할 수 없습니다.");
            }
        }
    }
}
