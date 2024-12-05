package vendingmachine.view;

import vendingmachine.domain.Coin;
import vendingmachine.dto.ChangeDto;
import vendingmachine.dto.GeneratedCoinDto;

import java.util.EnumMap;
import java.util.Map;
import java.util.Set;

public class OutputView {
    private static final String HAVE_COIN_MESSAGE = "\n자판기가 보유한 동전";
    private static final String CHANGE_MESSAGE = "잔돈";

    public void printExceptionMessage(String message) {
        System.out.println(message);
    }

    public void printGeneratedCoin(GeneratedCoinDto generatedCoinDto) {
        EnumMap<Coin, Integer> coins = generatedCoinDto.getCoins();

        Set<Map.Entry<Coin, Integer>> eachCoin = coins.entrySet();

        System.out.println(HAVE_COIN_MESSAGE);
        for (Map.Entry<Coin, Integer> coinIntegerEntry : eachCoin) {
            int amount = coinIntegerEntry.getKey().getAmount();
            Integer coinCount = coinIntegerEntry.getValue();

            System.out.println(amount + "원 - " + coinCount + "개");
        }
    }

    public void printChangeInfo(ChangeDto changeDto) {
        System.out.println(CHANGE_MESSAGE);
        Map<Coin, Integer> changeInfos = changeDto.getChangeInfos();
        for (Map.Entry<Coin, Integer> coinIntegerEntry : changeInfos.entrySet()) {
            System.out.println(
                    coinIntegerEntry.getKey().getAmount() + "원 - " + coinIntegerEntry.getValue() + "개"
            );
        }
    }
}
