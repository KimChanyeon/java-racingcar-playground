package racing;

public class Car {
    private String name;
    private Integer position;

    public Car(String name) {
        this.name = name;
        this.position = 0;
    }

    public String getName() {
        return name;
    }

    public Integer getPosition() {
        return position;
    }

    void setPosition(Integer position) {
        this.position = position;
    }

    public void goByIntValue(Integer value) {
        if (value != null && value > 3) {
            position++;
        }
    }
}
