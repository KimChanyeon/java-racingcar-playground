package racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.*;

class RacingTest {

    @Test
    @DisplayName("문자열을 받아서 car객체 생성 후 리스트에 담는다. car 의 이름은 , 로 구분")
    void initRacing() {
        // given
        String input = "pobi,crong,hounx";
        Racing racing = new Racing();

        // when
        racing.initRacing(input);

        // then
        assertThat(racing.getCars()).hasSize(3);
        assertThat(racing.getCars().stream().map(Car::getName).collect(Collectors.toList()))
                .containsExactly("pobi", "crong", "hounx");
        assertThat(racing.getCars().stream().map(Car::getPosition).collect(Collectors.toList()))
                .containsExactly(0, 0, 0);
    }

    @Test
    @DisplayName("자동차의 이름이 5글자 이상이면 예외 발생")
    void initRacingWithException() {
        // given
        String input = "pobipo";
        Racing racing = new Racing();

        // when

        // then
        assertThatThrownBy(() -> racing.initRacing(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("포지션이 제일 높은값을 가진 자동차 이름을 우승자 이름으로 반환한다.")
    void getWinner() {
        // given
        Racing racing = new Racing();
        Car car1 = new Car("car1");
        Car car2 = new Car("car2");
        Car car3 = new Car("car3");
        car1.setPosition(3);
        car2.setPosition(5);
        car3.setPosition(5);

        racing.getCars().add(car1);
        racing.getCars().add(car2);
        racing.getCars().add(car3);

        // when
        String winner = racing.getWinner();

        // then
        assertThat(winner).isEqualTo("car2, car3");
    }
}