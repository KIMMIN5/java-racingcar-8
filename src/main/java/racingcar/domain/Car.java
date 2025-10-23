package racingcar.domain;

public class Car {
    private final CarMoveRule carMoveRule;
    private final String name;
    private int distance;

    final static int NAME_MAX_LENGTH = 5;

    public Car(String name) throws IllegalArgumentException {
        if(!isValidateName(name) || name.isBlank()) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
        }
        this.name = name.trim();
        this.distance = 0;
        this.carMoveRule = new CarMoveRule();
    }

    public boolean isValidateName(String name) {
        return name.length() <= NAME_MAX_LENGTH;
    }

    public void forward() {
        if(carMoveRule.canMove()) {
            this.distance += 1;
        }
    }

    public int getDistance() {
        return distance;
    }

    public String getName() {
        return name;
    }
}
