package vendingmachine.dto;

import vendingmachine.domain.Coin;

import java.util.EnumMap;

public class GeneratedCoinDto {
    private final EnumMap<Coin, Integer> coins;

    public GeneratedCoinDto(EnumMap<Coin, Integer> coins) {
        this.coins = coins;
    }

    public EnumMap<Coin, Integer> getCoins() {
        return coins;
    }
}
