package racingcar;

import racingcar.domain.Car;
import racingcar.domain.dto.CarDto;
import racingcar.infra.RandomGeneratable;
import racingcar.infra.RandomGenerator;
import racingcar.view.Input;
import racingcar.view.Output;

import java.util.List;
import java.util.stream.Collectors;

public class Main {

    private static final RandomGeneratable randomGenerator = new RandomGenerator();

    public static void main(String[] args) {
        Output.printGetRacingCars();
        String carNames = Input.getCarNames();
        Output.printGetTryCount();
        int tryCount = Input.getTryCount();

        RacingGame racingGame = new RacingGame(carNames, tryCount, randomGenerator);

        playRounds(tryCount, racingGame);

        List<Car> winners = racingGame.getWinner();
        Output.printWinner(winners.stream()
                .map(it -> CarDto.from(it.getName(), it.getPosition()))
                .collect(Collectors.toList()));
    }

    private static void playRounds(int tryCount, RacingGame racingGame) {
        Output.printResultTitle();

        List<Car> cars = racingGame.getCars();
        Output.printResultStep(cars.stream()
                .map(it -> CarDto.from(it.getName(), it.getPosition()))
                .collect(Collectors.toList()));

        for (int i = 0; i < tryCount; i++) {
            racingGame.playRound();

            cars = racingGame.getCars();
            Output.printResultStep(cars.stream()
                    .map(it -> CarDto.from(it.getName(), it.getPosition()))
                    .collect(Collectors.toList()));
        }
    }
}
