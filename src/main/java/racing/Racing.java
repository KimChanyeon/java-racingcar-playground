package racing;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Racing {
    private final List<Car> cars;
    private Integer round;

    public Racing() {
        this.cars = new ArrayList<>();
    }

    public void initRacing(String input) {
        cars.clear();
        String[] names = input.split(",");
        for (String name : names) {
            carNameValidationCheck(name);
            addCar(name);
        }
    }

    public void rounding() {
        SecureRandom random = new SecureRandom();
        for (int i = 0; i < round; i++) {
            for (Car car : cars) {
                car.goByIntValue(random.nextInt(10));
                printState(car);
            }
            System.out.println();
        }

    }

    private static void printState(Car car) {
        StringBuilder processBar = new StringBuilder();
        for (int i = 0; i < car.getPosition(); i++) {
            processBar.append("-");
        }
        System.out.println(car.getName() + " : " + processBar);
    }

    public String getWinner() {
        int max = getMaxPosition();

        return cars.stream()
                .filter(car -> car.getPosition() == max)
                .map(Car::getName)
                .collect(Collectors.joining(", "));
    }

    private int getMaxPosition() {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);
    }

    private void carNameValidationCheck(String name) {
        if (name.length() > 5) {
            cars.clear();
            throw new IllegalArgumentException("자동차의 이름은 최대 5글자 까지 입니다.");
        }
    }

    private void addCar(String name) {
        cars.add(new Car(name));
    }

    List<Car> getCars() {
        return cars;
    }

    public void setRound(Integer round) {
        this.round = round;
    }
}
