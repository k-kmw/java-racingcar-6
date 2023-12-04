package racingcar.controller;

import racingcar.model.Cars;
import racingcar.model.Game;
import racingcar.model.dto.UserInput;
import racingcar.model.vo.Result;
import racingcar.service.RacingGameService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingGameController {

    private final InputView inputView;
    private final OutputView outputView;
    private final RacingGameService racingGameService;

    public RacingGameController(InputView inputView, OutputView outputView, RacingGameService racingGameService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.racingGameService = racingGameService;
    }

    public void start() {
        UserInput.CarNameDTO carNamesDTO = getCarNamesDTO();
        UserInput.TryNumDTO tryNumDTO = getTryNumDTO();
        Game game = racingGameService.createGame(carNamesDTO, tryNumDTO);
        Result result = racingGameService.play(game);
        outputView.printResultMessage(result);
        Cars winnerCars = racingGameService.getWinner(game);
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
}
