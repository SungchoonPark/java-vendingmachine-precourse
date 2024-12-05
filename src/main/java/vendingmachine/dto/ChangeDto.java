package vendingmachine.dto;

import vendingmachine.domain.Coin;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class ChangeDto {
    private final Map<Coin, Integer> changeInfos;

    public ChangeDto() {
        changeInfos = new LinkedHashMap<>();
    }

    public void addChangeValue(Coin coin) {
        changeInfos.put(coin, changeInfos.getOrDefault(coin, 0) + 1);
    }

    public Map<Coin, Integer> getChangeInfos() {
        return changeInfos;
    }
}
