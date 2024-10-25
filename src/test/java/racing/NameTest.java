package racing;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NameTest {

    @Test
    @DisplayName("인스턴스 생성시 이름이 5글자를 초과하면 예외를 발생시킨다.")
    void constructor_fail1() {
        // given // when // then
        Assertions.assertThatThrownBy(() -> new Name(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 Null 이나 빈 값일 수 없습니다.");

        Assertions.assertThatThrownBy(() -> new Name(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 Null 이나 빈 값일 수 없습니다.");

        Assertions.assertThatThrownBy(() -> new Name(" "))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 Null 이나 빈 값일 수 없습니다.");
    }

    @Test
    @DisplayName("인스턴스 생성시 이름이 5글자를 초과하면 예외를 발생시킨다.")
    void constructor_fail2() {
        // given // when // then
        Assertions.assertThatThrownBy(() -> new Name("가나다라마바"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 5글자를 초과할 수 없습니다.");
    }
}