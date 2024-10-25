package racing;

import java.util.Objects;

public class Car implements Comparable<Car> {
    private final Name name;
    private Position position;

    public Car(String name) {
        this.name = new Name(name);
        this.position = new Position();
    }

    public Car(String name, int position) {
        this.name = new Name(name);
        this.position = new Position(position);
    }

    public void move(int num) {
        if (num > 3) {
            position = position.increase();
        }
    }

    public String result() {
        return getResult();
    }

    private String getResult() {
        return name + " : " + position.getState();
    }

    public boolean isSamePositon(Car other) {
        return position.equals(other.position);
    }

    @Override
    public String toString() {
        return name.toString();
    }

    @Override
    public int compareTo(Car other) {
        return position.compareTo(other.position);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(name, car.name) && Objects.equals(position, car.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position);
    }
}
