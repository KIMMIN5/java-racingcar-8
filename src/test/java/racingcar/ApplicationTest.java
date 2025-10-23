package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    void 기능_테스트() {
        assertRandomNumberInRangeTest(
            () -> {
                run("pobi,woni", "1");
                assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi");
            },
            MOVING_FORWARD, STOP
        );
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("pobi,javaji", "1"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_1_1() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("abcdef, g", "1"))
                        .isInstanceOf(IllegalArgumentException.class));
    }

    @Test
    void 예외_2_2() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("a, ,c", "1"))
                        .isInstanceOf(IllegalArgumentException.class));
    }

    @Test
    void 예외_2_3() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("\n", "1"))
                        .isInstanceOf(IllegalArgumentException.class));
    }

    @Test
    void 예외_2_4_1() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("a,b,c", "-1"))
                        .isInstanceOf(IllegalArgumentException.class));
    }

    @Test
    void 예외_2_4_2() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("a,b,c", "0"))
                        .isInstanceOf(IllegalArgumentException.class));
    }

    @Test
    void 예외_2_4_3() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("a,b,c", "2.5"))
                        .isInstanceOf(IllegalArgumentException.class));
    }

    @Test
    void 예외_2_4_4() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("a,b,c", "five"))
                        .isInstanceOf(IllegalArgumentException.class));
    }

    @Test
    void 예외_2_4_5() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("a,b,c", "\n"))
                        .isInstanceOf(IllegalArgumentException.class));
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
