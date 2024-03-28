package racingcar;

public class Car {
    public static final int INIT_POSITION = 1;

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
        if (name.length() > 5) {
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
        if (randomNumber >= 4) {
            this.position++;
        }
    }
}
