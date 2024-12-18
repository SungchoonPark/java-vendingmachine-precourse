package vendingmachine.domain;

import vendingmachine.exception.ExceptionMessage;

public enum Coin {
    COIN_500(500),
    COIN_100(100),
    COIN_50(50),
    COIN_10(10);

    private final int amount;

    Coin(final int amount) {
        this.amount = amount;
    }

    // 추가 기능 구현

    public int getAmount() {
        return amount;
    }

    public static Coin getCoinByAmount(int amount) {
        for (Coin coin : Coin.values()) {
            if (coin.getAmount() == amount) return coin;
        }
        throw new IllegalArgumentException(ExceptionMessage.INVALID_INPUT.getMessage());
    }
}
