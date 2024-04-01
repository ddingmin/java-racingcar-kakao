package racingcar.domain;

import racingcar.infra.RandomGeneratable;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private final List<Car> cars;

    public Cars(List<Car> cars) {
        validateDuplicate(cars);
        this.cars = cars;
    }

    public Cars(String[] cars) {
        this(Arrays.stream(cars)
                .map(Car::new)
                .collect(Collectors.toList()));
    }

    public Cars(String input) {
        this(input.split(","));
    }

    public int size() {
        return this.cars.size();
    }

    public List<Car> getFarthest() {
        int farthestPosition = getFarthestPosition();
        return this.cars.stream()
                .filter(it -> farthestPosition == it.getPosition())
                .collect(Collectors.toList());
    }

    public List<Car> getAll() {
        return Collections.unmodifiableList(this.cars);
    }

    public void moveAll(RandomGeneratable randomGenerator) {
        this.cars.forEach(it -> it.move(randomGenerator.generate(0, 10)));
    }

    private int getFarthestPosition() {
        return this.cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElseThrow();
    }

    private void validateDuplicate(List<Car> cars) {
        if (new HashSet<>(cars).size() != cars.size()) {
            throw new IllegalArgumentException("중복된 자동차가 존재할 수 없습니다.");
        }
    }
}
