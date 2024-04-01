package racingcar;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.Car;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarTest {
    @ParameterizedTest
    @ValueSource(strings = {"a", "bb", "tom", "mark", "brown"})
    void 자동차는_5자_이하의_이름을_가진다(String carName) {
        Car car = new Car(carName);

        assertThat(car.getName()).isEqualTo(carName);
    }

    @ParameterizedTest
    @ValueSource(strings = {"bigName", "longName", "longestName"})
    void 자동차의_이름이_5글자_넘는다면_에러가_발생한다(String carName) {
        assertThatThrownBy(
                () -> new Car(carName)
        ).isInstanceOf(RuntimeException.class);
    }

    @ParameterizedTest
    @NullAndEmptySource
    void 자동차의_이름이_빈값_또는_널이라면_에러가_발생한다(String carName) {
        assertThatThrownBy(
                () -> new Car(carName)
        ).isInstanceOf(RuntimeException.class);
    }

    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    void 자동차는_4이상의_랜덤값일_경우_전진한다(int randomNumber) {
        int position = Car.INIT_POSITION;
        Car car = new Car("mark", position);

        car.move(randomNumber);

        assertThat(car.getPosition()).isEqualTo(position + 1);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    void 자동차는_3이하의_랜덤값일_경우_멈춘다(int randomNumber) {
        int position = Car.INIT_POSITION;
        Car car = new Car("mark", position);

        car.move(randomNumber);

        assertThat(car.getPosition()).isEqualTo(position);
    }
}
