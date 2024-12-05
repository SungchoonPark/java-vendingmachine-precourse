package vendingmachine.domain;

import vendingmachine.dto.GeneratedCoinDto;

public class VendingMachine {
    private CoinManager coinManager;
    private ProductManager productManager;

    public VendingMachine() {
        this.coinManager = new CoinManager();
    }

    public GeneratedCoinDto generatedVendingMachine(int totalMoney) {
        return coinManager.generatedRandomCoins(totalMoney);
    }
}
