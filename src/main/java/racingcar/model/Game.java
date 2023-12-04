package racingcar.model;

import racingcar.model.vo.Result;

import java.util.stream.Collectors;

public class Game {

    private final Referee referee;
    private final Cars cars;
    private final int tryNum;

    private Game(Referee referee, Cars cars, String inputTryNum) {
        validateTryNum(inputTryNum);
        this.referee = referee;
        this.cars = cars;
        this.tryNum = Integer.parseInt(inputTryNum);
    }

    private void validateTryNum(String userInput) {
        try {
            int tryNum = Integer.parseInt(userInput);
            if(tryNum < 1) {
                throw new IllegalArgumentException("시도 횟수는 1 이상이 되어야 합니다.");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도 횟수는 숫자를 입력해야 합니다.");
        }
    }

    public static Game create(Referee referee, Cars cars, String tryNum) {
        return new Game(referee, cars, tryNum);
    }

    public Result play() {
        Result result = new Result();
        for(int i=0; i<tryNum; i++) {
            raceOneTurn();
            updateResult(result, i);
        }
        return result;
    }

    public Cars getWinner() {
        return referee.judge(cars);
    }

    private void raceOneTurn() {
        cars.race();
    }

    private void updateResult(Result result, int i) {
        String oneStepResult = cars.getCars().stream()
                .map(car -> car.getName() + " : " + car.getTrack())
                .collect(Collectors.joining("\n"));
        result.getResult().append(oneStepResult);
        if (i == tryNum - 1) {
            result.getResult().append("\n");
            return;
        }
        if (i != tryNum -1) {
            result.getResult().append("\n\n");
        }
    }
}
