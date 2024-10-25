package racing;

import java.security.SecureRandom;
import java.util.Scanner;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        Racing racing = new Racing();

        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String input = scanner.nextLine();
        racing.setCars(new Cars(racing.getCarListByInput(input)));

        System.out.println("시도할 회수는 몇회인가요?");
        int round = scanner.nextInt();
        System.out.println("\n" + "실행 결과");

        SecureRandom random = new SecureRandom();
        for (int i = 0; i < round; i++) {
            racing.race(random);
            System.out.println(racing.result());
        }

        System.out.println(racing.winners() + "가 최종 우승했습니다.");

    }
}
