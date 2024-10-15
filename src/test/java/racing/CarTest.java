package racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class CarTest {

    @Test
    @DisplayName("4이상의 값을 받으면 한칸 전진한다")
    void goWhenValueGreaterThanThree() {
        // given
        Car car = new Car("car");

        // when
        car.goByIntValue(4);

        // then
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    @DisplayName("3이하의 값을 받으면 전진하지 않는다")
    void goWhenValueGreaterThanThree_fail() {
        // given
        Car car = new Car("car");

        // when
        car.goByIntValue(3);

        // then
        assertThat(car.getPosition()).isEqualTo(0);
    }

}