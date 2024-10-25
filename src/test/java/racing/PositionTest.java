package racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;

class PositionTest {

    @Test
    @DisplayName("인스턴스 생성시 위치가 음수값이면 예외를 발생시킨다.")
    void constructor_fail() {
        // given // when // then
        assertThatThrownBy(() -> new Position(-1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("위치는 음수가 될 수 없습니다.");
    }

    @Test
    @DisplayName("기본 생성자로 생성시 위치값은 0을 갖는다")
    void constructor() {
        // given
        Position position = new Position();

        // when
        boolean result = position.equals(new Position(0));

        // then
        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("포지션의 위치가 한단계 증가한다.")
    void increase() {
        // given
        Position position = new Position();

        // when
        position = position.increase();

        // then
        assertThat(position).isEqualTo(new Position(1));
    }

    @ParameterizedTest
    @CsvSource({"0,''", "1,-", "2,--"})
    @DisplayName("현재 위치를 상형화한 문자열을 반환한다.")
    void getState(int num, String expected) {
        // given
        Position position = new Position(num);

        // when
        String state = position.getState();

        // then
        assertThat(state).isEqualTo(expected);
    }
}