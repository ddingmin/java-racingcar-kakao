package racingcar.view;

import java.util.Scanner;

public class Input {

    private static final Scanner scanner = new Scanner(System.in);

    public static String getRacingCarsLine() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        return scanner.nextLine();
    }

    public static int getGameCount() {
        System.out.println("시도할 회수는 몇회인가요?");
        String input = scanner.nextLine();
        validateGameCount(input);
        return Integer.parseInt(input);
    }

    private static void validateGameCount(String input) {
        int count = Integer.parseInt(input);
        if (count < 0) {
            throw new IllegalArgumentException("게임 진행 횟수는 음수가될 수 없습니다.");
        }
    }
}
