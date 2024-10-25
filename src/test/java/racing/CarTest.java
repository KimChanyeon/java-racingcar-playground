package racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class CarTest {

    @Test
    @DisplayName("4이상의 값을 받으면 전진한다.")
    void move() {
        // given
        Car car1 = new Car("car");
        Car car2 = new Car("car", 1);

        // when
        car1.move(4);

        // then
        assertThat(car1.isSamePositon(car2)).isTrue();

    }

    @Test
    @DisplayName("3이하의 값을 받으면 전진하지 않는다.")
    void move_fail() {
        // given
        Car car1 = new Car("car");
        Car car2 = new Car("car");

        // when
        car1.move(3);

        // then
        assertThat(car1.isSamePositon(car2)).isTrue();
    }

    @Test
    @DisplayName("현재 상태를 상형화한 문자열을 반환한다.")
    void result() {
        // given
        Car car = new Car("car");

        // when
        car.move(4);

        // then
        assertThat(car.result()).isEqualTo("car : -");
    }

}