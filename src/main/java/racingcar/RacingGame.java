package racingcar;

import racingcar.infra.RandomGeneratable;

import java.util.List;

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

    public List<Car> getCarsStatus() {
        return this.cars.getAll();
    }

    public boolean isFinish() {
        return this.currentRound == this.purposeRound;
    }

    public List<Car> getWinner() {
        if (isFinish()) {
            return this.cars.getFarthest();
        }
        throw new RuntimeException("아직 모든 라운드의 게임이 종료되지 않았습니다.");
    }
}
