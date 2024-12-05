package vendingmachine.domain;

import camp.nextstep.edu.missionutils.Randoms;
import vendingmachine.dto.ChangeDto;
import vendingmachine.dto.GeneratedCoinDto;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CoinManager {
    private final EnumMap<Coin, Integer> coins;

    public CoinManager() {
        this.coins = new EnumMap<>(Coin.class);

        for (Coin coin : Coin.values()) {
            coins.put(coin, 0);
        }
    }

    public GeneratedCoinDto generatedRandomCoins(int totalMoney) {
        while (totalMoney > 0) {
            // 무작위 동전 선택
            int randomAmount = Randoms.pickNumberInList(List.of(
                    10, 50, 100, 500
            ));

            Coin randomCoin = Coin.getCoinByAmount(randomAmount);
            // 선택된 동전의 금액이 남은 금액보다 작거나 같은 경우 추가
            if (randomCoin.getAmount() <= totalMoney) {
                addCoins(randomCoin, 1);
                totalMoney -= randomCoin.getAmount();
            }
        }

        return new GeneratedCoinDto(this.coins);
    }

    private void addCoins(Coin coin, int count) {
        coins.put(coin, coins.get(coin) + count);
    }

    public ChangeDto generateChange(int clientInputMoney) {
        ChangeDto changeDto = new ChangeDto();
        Set<Map.Entry<Coin, Integer>> vendingCoins = coins.entrySet();

        for (Map.Entry<Coin, Integer> vendingCoin : vendingCoins) {
            Coin coin = vendingCoin.getKey();
            Integer value = vendingCoin.getValue();
            if (value == 0) continue;

            while (value != 0 && clientInputMoney != 0) {
                clientInputMoney -= coin.getAmount();
                value--;
                changeDto.addChangeValue(coin);
            }
        }

        return changeDto;
    }
}
