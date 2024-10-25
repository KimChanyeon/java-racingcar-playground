package racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RacingTest {

    @Test
    @DisplayName("입력값을 받아 , 표시로 구분하여 Car List를 생성한다.")
    void setupCarsByInput() {
        // given
        String input = "car1,car2,car3";
        Racing racing = new Racing();

        // when
        List<Car> carList = racing.getCarListByInput(input);

        // then
        assertThat(carList)
                .hasSize(3)
                .containsExactly(new Car("car1"), new Car("car2"), new Car("car3"));
    }
  
}