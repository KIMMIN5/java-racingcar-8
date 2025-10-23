package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private String name;
    private int distance;

    final static int NAME_MAX_LENGTH = 5;

    public Car(String name) throws IllegalArgumentException {
        if(!isValidateName(name) || name.isBlank()) {
            throw new IllegalArgumentException("이름은 5자 이하만 가능합니다.");
        }
        this.name = name;
        this.distance = 0;
    }

    public boolean isValidateName(String name) {
        return name.length() <= NAME_MAX_LENGTH;
    }

    public void forward() {
        if(Randoms.pickNumberInRange(0, 9) >= 4) {
            this.distance += 1;
        }
    }

    public void status() {
        System.out.print(name + " : ");
        for(int i=0; i<this.distance; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    public int getDistance() {
        return distance;
    }

    public String getName() {
        return name;
    }
}
