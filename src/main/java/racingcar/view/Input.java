package racingcar.view;

import java.util.Scanner;

public class Input {
    private static final Scanner scanner = new Scanner(System.in);

    public static String getCarNames() {
        String cars = scanner.nextLine();
        validateNullAndEmpty(cars);
        return cars;
    }

    public static int getTryCount() {
        int tryCount = scanner.nextInt();
        validateTryCount(tryCount);
        return tryCount;
    }

    private static void validateNullAndEmpty(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException("입력값은 널 또는 빈 값이 될 수 없습니다.");
        }
    }

    private static void validateTryCount(int tryCount) {
        if (tryCount < 0) {
            throw new IllegalArgumentException("시도 횟수는 0 미만이 될 수 없습니다.");
        }
    }
}
