package racingcar.controller;

import java.util.ArrayList;
import racingcar.domain.Car;
import racingcar.view.UserView;
import racingcar.domain.Race;

public class RaceController {
    private final UserView userview;
    private final Converter converter;

    public RaceController(UserView userview, Converter converter) {
        this.userview = userview;
        this.converter = converter;
    }

    public void run() {
        String rawCarNames = userview.inputOfCars();

        String rawTurns = userview.inputOfTurns();
        ArrayList<Car> cars = converter.convertToCar(rawCarNames);
        int turns = converter.convertToTurns(rawTurns);

        Race race = new Race(cars);
        userview.resultOfProcess();
        for(int t=0; t<turns; t++) {
            ArrayList<Car> statusOfRace = race.stepRace();
            userview.outputOfStatus(converter.convertToStatus(race.getCars()));
        }

        userview.outputOfWinner(converter.convertToWinner(race.findWinner(cars)));
    }
}
