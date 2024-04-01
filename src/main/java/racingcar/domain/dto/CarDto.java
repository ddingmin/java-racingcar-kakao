package racingcar.domain.dto;

public class CarDto {
    private final String name;
    private final int position;

    private CarDto(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public static CarDto from(String name, int position) {
        return new CarDto(name, position);
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}