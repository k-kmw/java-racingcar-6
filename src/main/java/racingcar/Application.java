package racingcar;

import racingcar.controller.RacingGameController;
import racingcar.service.CarsService;
import racingcar.service.RacingGameService;
import racingcar.service.RefereeService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {

        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        RefereeService refereeService = new RefereeService();
        CarsService carsService = new CarsService();
        RacingGameService racingGameService = new RacingGameService(refereeService, carsService);
        RacingGameController racingGameController = new RacingGameController(inputView, outputView, racingGameService);
        racingGameController.start();
    }
}
