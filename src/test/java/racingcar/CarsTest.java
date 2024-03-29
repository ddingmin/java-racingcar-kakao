package racingcar;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarsTest {
    @ParameterizedTest
    @CsvSource(value = {"pobi,crong,honux 3", "mark,pobi,crong,honux 4", "pobi 1"}, delimiter = ' ')
    void 자동차들의_이름들을_쉼표로_구분하여_부여한다(String input, int count) {
        Cars cars = new Cars(input);

        assertThat(cars.size()).isEqualTo(count);
    }

    @ParameterizedTest
    @CsvSource(value = {"pobi,pobi", "mark,pobi,crong,mark", "a,a,a,a"}, delimiter = ' ')
    void 자동차들의_이름들은_중복될_수_없다(String input) {
        assertThatThrownBy(() -> new Cars(input))
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    void 위치가_가장_먼_자동차들를_반환한다() {
        Car farthestCar = new Car("pobi", 5);
        Cars cars = new Cars(List.of(
                farthestCar,
                new Car("honux", 4),
                new Car("crong", 3)
        ));

        assertThat(cars.getFarthest()).isEqualTo(List.of(farthestCar));
    }
}
