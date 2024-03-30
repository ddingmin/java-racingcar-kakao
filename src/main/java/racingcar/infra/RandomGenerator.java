package racingcar.infra;

import java.util.Random;

public class RandomGenerator implements RandomGeneratable {
    private final static Random random = new Random();

    @Override
    public int generate(int min, int max) {
        return random.nextInt(max - min) + min;
    }
}
