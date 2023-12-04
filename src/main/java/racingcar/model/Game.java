package racingcar.model;

public class Game {

    private final Referee referee;
    private final Cars cars;

    public Game(Referee referee, Cars cars) {
        this.referee = referee;
        this.cars = cars;
    }
}
