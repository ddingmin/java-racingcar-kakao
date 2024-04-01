package racingcar;

import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.infra.RandomGeneratable;
import racingcar.infra.RandomGenerator;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class RacingGameTest {

    private final RandomGeneratable randomGenerator = new RandomGenerator();

    @Test
    void 자동차들의_이름과_시도_횟수를_입력받아_자동차_게임을_시작한다() {
        RacingGame game = new RacingGame("pobi,crong,honux", 5, randomGenerator);

        assertAll(
                () -> assertEquals(game.getCarsStatus(),
                        List.of(
                                new Car("pobi"),
                                new Car("crong"),
                                new Car("honux"))),
                () -> assertFalse(game.isFinish())
        );
    }

    @Test
    void 자동차_게임의_모든_라운드가_종료되면_우승자를_가린다() {
        RacingGame game = new RacingGame("pobi,crong,honux", 3, randomGenerator);

        game.playRound();
        game.playRound();
        game.playRound();

        assertAll(
                () -> assertTrue(game.isFinish()),
                () -> assertDoesNotThrow(game::getWinner)
        );
    }

    @Test
    void 자동차_게임의_모든_라운드가_종료되지_않은_경우_우승자를_가릴_수_없다() {
        RacingGame game = new RacingGame("pobi,crong,honux", 3, randomGenerator);

        game.playRound();

        assertThrows(RuntimeException.class, game::getWinner);
    }
}
