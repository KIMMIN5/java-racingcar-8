package racingcar;

import camp.nextstep.edu.missionutils.Console;
import racingcar.controller.Converter;
import racingcar.controller.RaceController;
import racingcar.view.UserView;


public class Application {
    public static void main(String[] args) {
        RaceController raceController = new RaceController(new UserView(), new Converter());
        raceController.run();
    }


}
