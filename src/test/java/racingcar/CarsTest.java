package racingcar;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.infra.RandomGeneratable;

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

    @Test
    void 모든_자동차들을_반환한다() {
        List<Car> carList = getStandardCars();
        Cars cars = new Cars(carList);

        assertThat(cars.getAll())
                .isEqualTo(carList);
    }

    @Test
    void 모든_자동차들을_이동시킨다() {
        RandomGeneratable output4Generator = new RandomGeneratable() {
            @Override
            public int generate(int min, int max) {
                return 4;
            }
        };
        Cars cars = new Cars(getStandardCars());

        cars.moveAll(output4Generator);

        assertThat(cars.getAll().stream()
                .mapToInt(Car::getPosition)
                .allMatch(it -> it == 2))
                .isTrue();
    }

    @Test
    void 조건에_부합하지_않은_경우_자동차들이_이동하지_않는다() {
        RandomGeneratable output0Generator = new RandomGeneratable() {
            @Override
            public int generate(int min, int max) {
                return 0;
            }
        };
        Cars cars = new Cars(getStandardCars());

        cars.moveAll(output0Generator);

        assertThat(cars.getAll().stream()
                .mapToInt(Car::getPosition)
                .allMatch(it -> it == 1))
                .isTrue();
    }

    private List<Car> getStandardCars() {
        return List.of(
                new Car("pobi", 1),
                new Car("honux", 1),
                new Car("crong", 1)
        );
    }
}
