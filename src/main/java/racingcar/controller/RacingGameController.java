package racingcar.controller;

import racingcar.model.Cars;
import racingcar.model.Game;
import racingcar.model.Referee;
import racingcar.model.dto.UserInput;
import racingcar.model.vo.Result;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingGameController {

    private final InputView inputView;
    private final OutputView outputView;

    public RacingGameController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void start() {
        UserInput.CarNameDTO carNamesDTO = getCarNamesDTO();
        UserInput.TryNumDTO tryNumDTO = getTryNumDTO();
        Game game = createGame(carNamesDTO, tryNumDTO);
        Result result = game.play();
        outputView.printResultMessage(result);
        Cars winnerCars = game.getWinner();
        outputView.printWinner(winnerCars);
    }

    private UserInput.CarNameDTO getCarNamesDTO() {
        outputView.printInputCarNamesMessage();
        return new UserInput.CarNameDTO(inputView.getString());
    }

    private UserInput.TryNumDTO getTryNumDTO() {
        outputView.printInputTryNumMessage();
        return new UserInput.TryNumDTO(inputView.getString());
    }

    private Game createGame(UserInput.CarNameDTO carNamesDTO, UserInput.TryNumDTO tryNumDTO) {
        Referee referee = new Referee();
        Cars cars = new Cars(carNamesDTO.toList());
        return new Game(referee, cars, tryNumDTO.getNum());
    }
}
