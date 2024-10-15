package racing;

import java.util.Scanner;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String input = scanner.nextLine();

        Racing racing = new Racing();
        racing.initRacing(input);

        System.out.println("시도할 회수는 몇회인가요?");
        int round = scanner.nextInt();
        scanner.nextLine();

        racing.setRound(round);

        System.out.println();
        System.out.println("실행 결과");

        racing.rounding();

        System.out.println(racing.getWinner() + "이/가 최종 우승했습니다.");
    }
}
