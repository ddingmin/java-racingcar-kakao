package racingcar.view;


import racingcar.domain.dto.CarDto;

import java.util.List;
import java.util.stream.Collectors;

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

    public static void printResultStep(List<CarDto> cars) {
        for (CarDto car : cars) {
            System.out.println(car.getName() + " : " + POSITION_CHARACTER.repeat(car.getPosition()));
        }
        System.out.println();
    }

    public static void printWinner(List<CarDto> cars) {
        String winners = cars.stream()
                .map(CarDto::getName)
                .collect(Collectors.joining(", "));
        System.out.println(winners + "가 최종 우승했습니다.");
    }

}
