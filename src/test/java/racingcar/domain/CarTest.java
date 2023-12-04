package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingcar.model.Car;

public class CarTest {

    @ParameterizedTest
    @CsvSource({"0, '', 1, '', 2, '', 3, '', 4, '-', 5, '-', 6, '-', 7, '-', 8, '-', 9, '-'"})
    void moveTest(int randomNum, String expected) {
        // given
        Car car = new Car("Test Car");

        // when
        car.tryMove(randomNum);

        // then
        Assertions.assertThat(car.getTrack().toString()).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource({"3, '', 4, '--', 5, '--'"})
    void moveTwoTest(int randomNum, String expected) {
        // given
        Car car = new Car("Test Car");

        // when
        car.tryMove(randomNum);
        car.tryMove(randomNum);

        // then
        Assertions.assertThat(car.getTrack().toString()).isEqualTo(expected);
    }
}
