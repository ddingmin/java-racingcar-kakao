package racingcar.view;


import java.util.List;

public class Output {

    public static final String POSITION_CHARACTER = "-";

    public static void printGetRacingCars() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
    }

    public static void printGetTryCount() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    public static void printResultTitle() {
        System.out.println("\n실행 결과");
    }

    public static void printResultStep(List<String> carNames, List<Integer> carPositions) {
        validateSize(carNames, carPositions);

        for (int i = 0; i < carNames.size(); i++) {
            System.out.println(carNames.get(i) + " : " + POSITION_CHARACTER.repeat(carPositions.get(i)));
        }
        System.out.println();
    }

    public static void printWinner(List<String> carNames) {
        System.out.println(String.join(", ", carNames) + "가 최종 우승했습니다.");
    }

    private static void validateSize(List<String> carNames, List<Integer> carPositions) {
        if (carNames.size() != carPositions.size()) {
            throw new IllegalArgumentException("자동차 이름의 수와 위치 수가 다릅니다.");
        }
    }
}
