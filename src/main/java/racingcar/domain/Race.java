package racingcar.domain;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class Race {
    private final ArrayList<Car> cars;

    public Race(ArrayList<Car> cars) throws IllegalArgumentException {
        this.cars = new ArrayList<>(cars);
    }

    public ArrayList<Car> stepRace() {
        cars.forEach(Car::forward);
        return cars;
    }

    public ArrayList<Car> getCars() {
        return cars;
    }

    public ArrayList<Car> findWinner(ArrayList<Car> cars) {
        int maxDistance = cars.stream()
                .mapToInt(Car::getDistance)
                .max()
                .orElse(0);

        return cars.stream()
                .filter(car -> car.getDistance() == maxDistance)
                .collect(Collectors.toCollection(ArrayList::new));
    }
}
