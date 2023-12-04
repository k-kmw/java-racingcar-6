package racingcar.model;

import racingcar.model.vo.Result;

public class Game {

    private final Referee referee;
    private final Cars cars;
    private final int tryNum;

    public Game(Referee referee, Cars cars, int tryNum) {
        this.referee = referee;
        this.cars = cars;
        this.tryNum = tryNum;
    }

    public Result play() {
        Result result = new Result();
        for(int i=0; i<tryNum; i++) {
            cars.race();
            for (Car car : cars.getCars()) {
                result.getTrack().append(car.getName()).append(" : ").append(car.getTrack()).append("\n");
            }
            if(i != tryNum-1) {
                result.getTrack().append("\n");
            }
        }
        return result;
    }

    public Cars getWinner() {
        return referee.judge(cars);
    }
}
