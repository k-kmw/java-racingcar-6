package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class Referee {
    public Cars judge(Cars cars) {
        int mx = 0;
        List<Car> winnerCars = new ArrayList<>();
        for (Car car : cars.getCars()) {
            if(car.getTrack().length() > mx) {
                mx = car.getTrack().length();
            }
        }
        for (Car car : cars.getCars()) {
            if (car.getTrack().length() == mx) {
                winnerCars.add(car);
            }
        }
        return new Cars(winnerCars);
    }
}
