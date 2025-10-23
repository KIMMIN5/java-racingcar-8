package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class CarMoveRule {
    public boolean canMove() {
        return Randoms.pickNumberInRange(0,9) >= 4;
    }
}
