package racingcar.view;

import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.model.vo.Result;

import java.util.List;

public class OutputView {
    public void printInputCarNamesMessage() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public void printInputTryNumMessage() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    public void printResultMessage(Result result) {
        System.out.println("실행 결과");
        System.out.println(result.getTrack());
    }

    public void printWinner(Cars cars) {
        System.out.print("최종 우승자: ");
        List<Car> winnerCars = cars.getCars();
        for (int i = 0; i < winnerCars.size(); i++) {
            if (i == winnerCars.size() - 1) {
                System.out.println(winnerCars.get(i).getName());
            } else {
                System.out.print(winnerCars.get(i).getName() + ", ");
            }
        }
    }
}
