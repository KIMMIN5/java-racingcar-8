package racingcar;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Race {
    int step;
    ArrayList<Car> cars;

    public Race(String carsName) {
        this.cars = new ArrayList<Car>();
        String[] splitCarName = carsName.split(",");
        for(String carName: splitCarName) {
            cars.add(new Car(carName));
        }
    }

    public void setStep(int step) throws IllegalArgumentException{
        if(step <= 0) {
            throw new IllegalArgumentException("음수 및 0은 입력할 수 없습니다.");
        }
        this.step = step;
    }

    public String startRace() {
        for(int s=0; s<step; s++) {
            cars.forEach(Car::forward);
            cars.forEach(Car::status);
            System.out.println();
        }
        return findWinner(cars);
    }

    public String findWinner(ArrayList<Car> cars) {
        int maxDistance = cars.stream()
                .mapToInt(Car::getDistance)
                .max()
                .orElse(0);

        ArrayList<Car> winnerCars = cars.stream()
                .filter(car -> car.getDistance() == maxDistance)
                .collect(Collectors.toCollection(ArrayList::new));

        return winnerCars.stream()
                .map(Car::getName)
                .collect(Collectors.joining(", "));
    }
}
