package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import racingcar.domain.Car;

public class UserView {

    public String inputOfCars() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return Console.readLine();
    }

    public String inputOfTurns() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        return Console.readLine();
    }

    public void resultOfProcess() {
        System.out.println("실행 결과");
    }

    public void outputOfStatus(String status) {
        System.out.print(status);
        System.out.println("\n");
    }

    public void outputOfWinner(String winnerCars) {
        System.out.println("최종 우승자 : " + winnerCars);
    }
}
