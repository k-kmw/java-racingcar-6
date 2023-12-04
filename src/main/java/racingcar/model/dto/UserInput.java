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

        private void validate(String userInput) {
            String[] carNames = userInput.split(",");
            if (carNames.length == 1) {
                throw new IllegalArgumentException("[Error] 유효하지 않은 자동차 이름");
            }
            for (String carName : carNames) {
                if (carName.length() > 5) {
                    throw new IllegalArgumentException("[Error] 자동차 이름은 5글자 이하");
                }
            }
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

        private void validate(String userInput) {
            try {
                int tryNum = Integer.parseInt(userInput);
                if (tryNum < 0) {
                    throw new IllegalArgumentException("[Error] 유효하지 않은 시도할 횟수");
                }
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("[Error] 유효하지 않은 시도할 횟수");
            }
        }

        public int getNum() {
            return Integer.parseInt(tryNum);
        }
    }
}
