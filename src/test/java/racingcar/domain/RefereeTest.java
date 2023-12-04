package racingcar.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.model.Referee;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class RefereeTest {

    @ParameterizedTest
    @MethodSource("judgeOneWinnerTestInput")
    void judgeOneWinnerTest(Cars cars, Cars expected) {
        // given
        Referee referee = new Referee();

        // when
        Cars winningCars = referee.judge(cars);

        // then
        Assertions.assertEquals(expected.getCars(), winningCars.getCars());
    }

    @ParameterizedTest
    @MethodSource("judgeMoreThanOneWinnerTestInput")
    void judgeMoreThanOneWinnerTest(Cars cars, Cars expected) {
        // given
        Referee referee = new Referee();

        // when
        Cars winningCars = referee.judge(cars);

        // then
        System.out.println("actual: ");
        for (Car car : cars.getCars()) {
            System.out.println(car.getName());
        }
        System.out.println("expected: ");
        for (Car car : expected.getCars()) {
            System.out.println(car.getName());
        }
        Assertions.assertEquals(expected.getCars(), winningCars.getCars());
    }

    private static Stream<Arguments> judgeOneWinnerTestInput() {
        List<Car> cars = new ArrayList<>();

        Car car = new Car("A");
        car.tryMove(4);
        car.tryMove(5);
        cars.add(car);
        Car car2 = new Car("B");
        car2.tryMove(3);
        car2.tryMove(4);
        Car car3 = new Car("C");
        car3.tryMove(1);
        car3.tryMove(2);
        cars.add(car2);

        List<Car> winningCars = new ArrayList<>();
        winningCars.add(car);

        return Stream.of(
                Arguments.of(new Cars(cars), new Cars(winningCars))
        );
    }

    private static Stream<Arguments> judgeMoreThanOneWinnerTestInput() {
        List<Car> cars = new ArrayList<>();

        Car car = new Car("A");
        car.tryMove(4);
        car.tryMove(5);
        cars.add(car);
        Car car2 = new Car("B");
        car2.tryMove(5);
        car2.tryMove(6);
        Car car3 = new Car("C");
        car3.tryMove(1);
        car3.tryMove(2);
        cars.add(car2);

        List<Car> winningCars = new ArrayList<>();
        winningCars.add(car);
        winningCars.add(car2);

        return Stream.of(
                Arguments.of(new Cars(cars), new Cars(winningCars))
        );
    }
}
