package racingcar.controller;

import java.util.ArrayList;
import java.util.stream.Collectors;
import racingcar.domain.Car;

public class Converter {
    public Converter() {}

    public ArrayList<Car> convertToCar(String rawCarNames) throws IllegalArgumentException {
        if(rawCarNames.isEmpty()) {
            throw new IllegalArgumentException("빈 값은 입력 불가능 합니다.");
        }
        ArrayList<Car> cars = new ArrayList<Car>();
        String[] splitCarNames = rawCarNames.split(",");

        for(String carName: splitCarNames) {
            if(carName.isBlank()) {
                throw new IllegalArgumentException("공백을 이름으로 지정할 수 없습니다.");
            }
            cars.add(new Car(carName));
        }
        return cars;
    }

    public int convertToTurns(String rawTurns) throws IllegalArgumentException{
        try {
            if(rawTurns.isBlank()) {
                throw new IllegalArgumentException("빈 값은 입력 불가능 합니다.");
            }

            int turns = Integer.parseInt(rawTurns.trim());

            if (turns <= 0) {
                throw new IllegalArgumentException("턴은 양의 정수만 입력가능합니다.");
            }

            return turns;
        }catch(NumberFormatException e) {
            throw new IllegalArgumentException("턴은 양의 정수만 가능합니다.");
        }
    }

    public String convertToStatus(ArrayList<Car> cars) {
        return cars.stream()
                .map(car -> car.getName() + " : " + "-".repeat(car.getDistance()))
                .collect(Collectors.joining("\n"));
    }

    public String convertToWinner(ArrayList<Car> cars) {
        return cars.stream()
                .map(Car::getName)
                .collect(Collectors.joining(", "));
    }

}
