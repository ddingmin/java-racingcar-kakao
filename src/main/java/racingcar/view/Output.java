package racingcar.view;

import racingcar.Car;

import java.util.List;
import java.util.stream.Collectors;

public class Output {

    public static void printGetRacingCars() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
    }

    public static void printGetTryCount() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    public static void printResultTitle() {
        System.out.println("\n실행 결과");
    }

    public static void printResultStep(List<Car> cars) {
        cars.forEach(it -> System.out.println(it.getName() + " : " + "-".repeat(it.getPosition())));
        System.out.println();
    }

    public static void printWinner(List<Car> cars) {
        System.out.println(
                cars.stream()
                        .map(Car::getName)
                        .collect(Collectors.joining(", "))
                        + "가 최종 우승했습니다.");
    }
}
