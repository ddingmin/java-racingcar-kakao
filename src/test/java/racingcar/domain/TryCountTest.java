package racingcar.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.TryCount;

class TryCountTest {
    @ParameterizedTest
    @ValueSource(ints = {0, 1, 100})
    void 시도_횟수는_0_이상의_숫자_이어야한다(int tryCount) {
        Assertions.assertDoesNotThrow(() -> new TryCount(tryCount));
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, -100})
    void 시도_횟수가_0_미만이라면_예외를_던진다(int tryCount) {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new TryCount(tryCount));
    }
}
