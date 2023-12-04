package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class Referee {
    public Cars judge(Cars cars) {
        int maxMoveNum = findMaxMoveNum(cars);
        return getWinnerCars(cars, maxMoveNum);
    }

    private Cars getWinnerCars(Cars cars, int maxMoveNum) {
        return new Cars(cars.getCars().stream()
                .filter(car -> car.getTrack().length() == maxMoveNum)
                .toList());
    }

    private int findMaxMoveNum(Cars cars) {
         return cars.getCars().stream()
                .mapToInt(car -> car.getTrack().length())
                .max()
                .orElse(0);
    }
}
