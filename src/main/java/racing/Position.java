package racing;

import java.util.Objects;
import java.util.Optional;

public class Position implements Comparable<Position> {
    private final int value;

    public Position() {
        this(0);
    }

    public Position(int value) {
        if (value < 0) {
            throw new IllegalArgumentException("위치는 음수가 될 수 없습니다.");
        }
        this.value = value;
    }

    public Position increase() {
        return new Position(value + 1);
    }

    public boolean lessThan(Position position) {
        return this.value < position.value;
    }

    public String getState() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < value; i++) {
            sb.append("-");
        }
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position1 = (Position) o;
        return value == position1.value;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(Optional.of(value));
    }

    @Override
    public int compareTo(Position position) {
        return Integer.compare(this.value, position.value);
    }
}
