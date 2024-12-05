package vendingmachine.view;

import camp.nextstep.edu.missionutils.Console;
import vendingmachine.exception.ExceptionMessage;

public class InputView {
    private static final String VENDINGMACHINE_HAVE_MONEY_MESSAGE = "자판기가 보유하고 있는 금액을 입력해 주세요.";

    public int readVendingMachineMoney() {
        System.out.println(VENDINGMACHINE_HAVE_MONEY_MESSAGE);
        String vendingMachineMoney = Console.readLine();

        checkInputIsEmpty(vendingMachineMoney);
        int money = checkVendingMachineMoneyIsNum(vendingMachineMoney);
        checkVendingMachineMoneyCanDividedTen(money);

        return money;
    }

    private void checkInputIsEmpty(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_INPUT.getMessage());
        }
    }

    private int checkVendingMachineMoneyIsNum(String money) {
        try {
            return Integer.parseInt(money);
        } catch (Exception e) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_INPUT.getMessage());
        }
    }

    private void checkVendingMachineMoneyCanDividedTen(int money) {
        if (money % 10 != 0) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_VENDINGMACHINE_MONEY.getMessage());

        }
    }
}
