package racingcar.model.dto;

import racingcar.model.Car;

import java.util.ArrayList;
import java.util.List;

public class UserInput {

    public static class CarNameDTO {

        private final String carNames;

        public CarNameDTO(String carNames) {
            validate(carNames);
            this.carNames = carNames;
        }

        private void validate(String carNames) {

        }

        public String getCarNames() {
            return carNames;
        }

        public List<Car> toList() {
            List<Car> cars = new ArrayList<>();
            String[] carNames = this.carNames.split(",");
            for (String carName : carNames) {
                cars.add(new Car(carName));
            }
            return cars;
        }
    }

    public static class TryNumDTO {

        private final String tryNum;

        public TryNumDTO(String tryNum) {
            validate(tryNum);
            this.tryNum = tryNum;
        }

        private void validate(String tryNum) {

        }

        public int getNum() {
            return Integer.parseInt(tryNum);
        }
    }
}
