package vendingmachine.view;

import camp.nextstep.edu.missionutils.Console;
import vendingmachine.exception.ExceptionMessage;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputView {
    private static final String VENDINGMACHINE_HAVE_MONEY_MESSAGE = "자판기가 보유하고 있는 금액을 입력해 주세요.";
    private static final String VENDINGMACHINE_PRODUCTS_MESSAGE = "\n상품명과 가격, 수량을 입력해 주세요.";

    private static final String REGEX = "\\[[\\w가-힣]+,\\d+,\\d+\\]";
    private static final Pattern pattern = Pattern.compile(REGEX);

    public int readVendingMachineMoney() {
        System.out.println(VENDINGMACHINE_HAVE_MONEY_MESSAGE);
        String vendingMachineMoney = Console.readLine();

        checkInputIsEmpty(vendingMachineMoney);
        int money = checkVendingMachineMoneyIsNum(vendingMachineMoney);
        checkVendingMachineMoneyCanDividedTen(money);

        return money;
    }

    public String readVendingMachineProducts() {
        System.out.println(VENDINGMACHINE_PRODUCTS_MESSAGE);
        String products = Console.readLine();
        checkInputIsEmpty(products);
        checkValidProductFormat(products);

        return products;
    }

    private void checkInputIsEmpty(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_INPUT.getMessage());
        }
    }

    private void checkValidProductFormat(String products) {
        String[] productList = products.split(";");

        for (String product : productList) {
            System.out.println("product = " + product);
            Matcher matcher = pattern.matcher(product);
            if (!matcher.matches()) {
                throw new IllegalArgumentException(ExceptionMessage.INVALID_PRODUCT_FORMAT.getMessage());
            }
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
