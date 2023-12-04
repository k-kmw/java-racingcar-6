package racingcar.model.dto;

import racingcar.model.Car;

import java.util.ArrayList;
import java.util.List;

public class UserInput {

    public static class CarNameDTO {

        private final String carNames;

        public CarNameDTO(String carNames) {
            validateNotNull(carNames);
            this.carNames = carNames;
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
            validateNotNull(tryNum);
            this.tryNum = tryNum;
        }

        public String getNum() {
            return tryNum;
        }
    }

    private static void validateNotNull(String userInput) {
        if (userInput.isEmpty()) {
            throw new IllegalArgumentException("[Error] 유효하지 않은 입력입니다.");
        }
    }
}
