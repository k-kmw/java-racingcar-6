package racingcar.service;

import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.model.Game;
import racingcar.model.Referee;
import racingcar.model.vo.Result;

import java.util.List;

public class RacingGameService {

    private final RefereeService refereeService;
    private final CarsService carsService;

    public RacingGameService(RefereeService refereeService, CarsService carsService) {
        this.refereeService = refereeService;
        this.carsService = carsService;
    }

    public Game createGame(List<Car> carList, String tryNum) {
        Referee referee = refereeService.createReferee();
        Cars cars = carsService.createCars(carList);
        return Game.create(referee, cars, tryNum);
    }

    public Result play(Game game) {
        return game.play();
    }

    public Cars getWinner(Game game) {
        return game.getWinner();
    }
}
