package racingcar;

import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.dto.CarDto;
import racingcar.infra.RandomGeneratable;

import java.util.List;
import java.util.stream.Collectors;

public class RacingGame {

    private final Cars cars;
    private final int purposeRound;
    private final RandomGeneratable randomGenerator;

    private int currentRound = 0;

    public RacingGame(String cars, int tryCount, RandomGeneratable randomGenerator) {
        this.cars = new Cars(cars);
        this.purposeRound = tryCount;
        this.randomGenerator = randomGenerator;
    }

    public void playRound() {
        if (this.currentRound >= purposeRound) {
            throw new IllegalArgumentException("최대 수행 라운드에 도달했습니다.");
        }
        currentRound++;
        cars.moveAll(randomGenerator);
    }

    public List<CarDto> getCars() {
        return convertToCarDtos(cars.getAll());
    }

    public boolean isFinish() {
        return this.currentRound == this.purposeRound;
    }

    public List<CarDto> getWinner() {
        if (isFinish()) {
            return convertToCarDtos(cars.getFarthest());
        }
        throw new RuntimeException("아직 모든 라운드의 게임이 종료되지 않았습니다.");
    }

    private List<CarDto> convertToCarDtos(List<Car> cars) {
        return cars.stream()
                .map(CarDto::from)
                .collect(Collectors.toList());
    }
}
