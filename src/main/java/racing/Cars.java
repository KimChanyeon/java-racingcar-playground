package racing;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Cars {
    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> getWinners() {
        List<Car> winners = new ArrayList<>();
        Collections.sort(cars);

        for (Car car : cars) {
            if (car.isSamePositon(cars.get(cars.size() - 1))) {
                winners.add(car);
            }
        }
        return winners;
    }

    public String result() {
        StringBuilder sb = new StringBuilder();
        for (Car car : cars) {
            sb.append(car.result());
            sb.append("\n");
        }
        return sb.toString();
    }

    public void rounding(SecureRandom random) {
        for (Car car : cars) {
            car.move(random.nextInt(10));
        }
    }
}
