package racingcar;

import racingcar.domain.Car;
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

        Output.printWinner(racingGame.getWinner().stream().map(Car::getName).collect(Collectors.toList()));
    }

    private static void playRounds(int tryCount, RacingGame racingGame) {
        Output.printResultTitle();

        List<Car> status = racingGame.getCarsStatus();
        Output.printResultStep(status.stream().map(Car::getName).collect(Collectors.toList()),
                status.stream().map(Car::getPosition).collect(Collectors.toList()));

        for (int i = 0; i < tryCount; i++) {
            racingGame.playRound();

            status = racingGame.getCarsStatus();
            Output.printResultStep(status.stream().map(Car::getName).collect(Collectors.toList()),
                    status.stream().map(Car::getPosition).collect(Collectors.toList()));
        }
    }
}
