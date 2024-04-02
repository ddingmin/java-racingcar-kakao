package racingcar;

import racingcar.domain.TryCount;
import racingcar.domain.dto.CarDto;
import racingcar.infra.RandomGeneratable;
import racingcar.infra.RandomGenerator;
import racingcar.view.Input;
import racingcar.view.Output;

import java.util.List;

public class Main {

    private static final RandomGeneratable randomGenerator = new RandomGenerator();

    public static void main(String[] args) {
        Output.printGetRacingCars();
        String carNames = Input.getCarNames();
        Output.printGetTryCount();
        TryCount tryCount = new TryCount(Input.getTryCount());

        RacingGame racingGame = new RacingGame(carNames, tryCount.getCount(), randomGenerator);

        playRounds(tryCount, racingGame);

        List<CarDto> winners = racingGame.getWinner();
        Output.printWinner(winners);
    }

    private static void playRounds(TryCount tryCount, RacingGame racingGame) {
        Output.printResultTitle();

        List<CarDto> cars = racingGame.getCars();
        Output.printResultStep(cars);
        for (int i = 0; i < tryCount.getCount(); i++) {
            racingGame.playRound();

            cars = racingGame.getCars();
            Output.printResultStep(cars);
        }
    }
}
