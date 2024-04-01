package racingcar.domain;

public class TryCount {
    private final int count;

    public TryCount(int count) {
        validateSize(count);
        this.count = count;
    }

    private void validateSize(int count) {
        if (count < 0) {
            throw new IllegalArgumentException("시도 횟수는 0 미만이 될 수 없습니다.");
        }
    }

    public int getCount() {
        return count;
    }
}
