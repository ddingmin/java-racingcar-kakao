package racingcar;

import java.util.Objects;

public class Car {
    public static final int INIT_POSITION = 1;
    public static final int MAX_NAME_LENGTH = 5;
    public static final int MOVE_BOUND = 4;

    private final String name;
    private int position;

    public Car(String name, int position) {
        validateCarName(name);
        this.name = name;
        this.position = position;
    }

    public Car(String name) {
        this(name, INIT_POSITION);
    }

    private void validateCarName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("자동차의 이름은 널 또는 빈값일 수 없습니다");
        }
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("자동차의 이름은 5자 이하만 가능합니다");
        }
    }

    public String getName() {
        return this.name;
    }

    public int getPosition() {
        return this.position;
    }

    public void move(int randomNumber) {
        if (randomNumber >= MOVE_BOUND) {
            this.position++;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
