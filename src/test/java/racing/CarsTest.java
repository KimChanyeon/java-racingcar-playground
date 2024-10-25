package racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {

    @Test
    @DisplayName("가장 많이 전진한 자동차의 목록을 가져온다.")
    void getWinners() {
        // given
        Car car1 = new Car("car1", 1);
        Car car2 = new Car("car2", 2);
        Car car3 = new Car("car3", 2);
        List<Car> list = new ArrayList<>();
        list.add(car1);
        list.add(car2);
        list.add(car3);

        Cars cars = new Cars(list);

        // when
        List<Car> winners = cars.getWinners();

        // then
        assertThat(winners).hasSize(2)
                .containsExactlyInAnyOrder(car2, car3);
    }

    @Test
    @DisplayName("현재 경주 상황을 형상화한 문자열을 반환한다.")
    void result() {
        // given
        Car car1 = new Car("car1", 1);
        Car car2 = new Car("car2", 2);
        Car car3 = new Car("car3", 2);
        List<Car> list = new ArrayList<>();
        list.add(car1);
        list.add(car2);
        list.add(car3);

        Cars cars = new Cars(list);

        // when
        String result = cars.result();

        // then
        assertThat(result).isEqualTo("car1 : -\ncar2 : --\ncar3 : --\n");
    }

}