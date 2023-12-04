package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.model.dto.UserInput;

public class InputView {
    public String getString() {
        return Console.readLine();
    }
}
