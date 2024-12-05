package vendingmachine.view;

import vendingmachine.domain.Coin;
import vendingmachine.dto.GeneratedCoinDto;

import java.util.EnumMap;
import java.util.Map;
import java.util.Set;

public class OutputView {

    public void printExceptionMessage(String message) {
        System.out.println(message);
    }

    public void printGeneratedCoin(GeneratedCoinDto generatedCoinDto) {
        EnumMap<Coin, Integer> coins = generatedCoinDto.getCoins();

        Set<Map.Entry<Coin, Integer>> eachCoin = coins.entrySet();

        for (Map.Entry<Coin, Integer> coinIntegerEntry : eachCoin) {
            int amount = coinIntegerEntry.getKey().getAmount();
            Integer coinCount = coinIntegerEntry.getValue();

            System.out.println(amount + "원 - " + coinCount + "개");
        }
    }
}
