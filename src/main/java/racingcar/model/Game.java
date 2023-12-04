package racingcar.model;

import racingcar.model.dto.UserInput;
import racingcar.model.vo.Result;

import java.util.stream.Collectors;

public class Game {

    private final Referee referee;
    private final Cars cars;
    private final int tryNum;

    private Game(Referee referee, Cars cars, int tryNum) {
        this.referee = referee;
        this.cars = cars;
        this.tryNum = tryNum;
    }

    public static Game create(UserInput.CarNameDTO carNamesDTO, UserInput.TryNumDTO tryNumDTO) {
        Referee referee = new Referee();
        Cars cars = new Cars(carNamesDTO.toList());
        return new Game(referee, cars, tryNumDTO.getNum());
    }

    public Result play() {
        Result result = new Result();
        for(int i=0; i<tryNum; i++) {
            cars.race();
            updateResult(result, i);
        }
        return result;
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

    public Cars getWinner() {
        return referee.judge(cars);
    }
}
