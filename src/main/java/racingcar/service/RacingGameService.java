package racingcar.service;

import racingcar.model.Cars;
import racingcar.model.Game;
import racingcar.model.dto.UserInput;
import racingcar.model.vo.Result;

public class RacingGameService {

    public Game createGame(UserInput.CarNameDTO carNamesDTO, UserInput.TryNumDTO tryNumDTO) {
        return Game.create(carNamesDTO, tryNumDTO);
    }

    public Result play(Game game) {
        return game.play();
    }

    public Cars getWinner(Game game) {
        return game.getWinner();
    }
}
