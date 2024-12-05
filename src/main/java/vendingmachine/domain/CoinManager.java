package vendingmachine.domain;

import camp.nextstep.edu.missionutils.Randoms;
import vendingmachine.dto.GeneratedCoinDto;

import java.util.EnumMap;

public class CoinManager {
    private final EnumMap<Coin, Integer> coins;

    public CoinManager() {
        this.coins = new EnumMap<>(Coin.class);

        for(Coin coin : Coin.values()) {
            coins.put(coin, 0);
        }
    }

    public GeneratedCoinDto generatedRandomCoins(int totalMoney) {
        Coin[] coins = Coin.values();

        while (totalMoney > 0) {
            // 무작위 동전 선택
            Coin randomCoin = coins[Randoms.pickNumberInRange(0, 3)];

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
}
