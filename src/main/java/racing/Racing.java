package racing;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Racing {
    private Cars cars;

    public List<Car> getCarListByInput(String input) {
        StringTokenizer carToken = new StringTokenizer(input, ",");

        List<Car> carList = new ArrayList<>();

        while (carToken.hasMoreTokens()) {
            carList.add(new Car(carToken.nextToken()));
        }

        return carList;
    }

    public void race(SecureRandom random) {
        cars.rounding(random);
    }

    public String winners() {
        return cars.getWinners().stream().map(Car::toString).collect(Collectors.joining(", "));
    }

    public String result() {
        return cars.result();
    }

    public void setCars(Cars cars) {
        this.cars = cars;
    }
}
