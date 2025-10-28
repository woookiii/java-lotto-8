package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        guideCostInput();

        final String costInput = getInput();
    }

    private static String getInput() {
        return Console.readLine();
    }

    private static void guideCostInput() {
        System.out.println("구입금액을 입력해 주세요.");
    }
}
