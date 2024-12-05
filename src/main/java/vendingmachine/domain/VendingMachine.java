package vendingmachine.domain;

import vendingmachine.dto.GeneratedCoinDto;

public class VendingMachine {
    private CoinManager coinManager;
    private ProductManager productManager;

    public VendingMachine() {
        this.coinManager = new CoinManager();
        this.productManager = new ProductManager();
    }

    public GeneratedCoinDto generatedVendingMachine(int totalMoney) {
        return coinManager.generatedRandomCoins(totalMoney);
    }

    public void addProducts(String products) {
        productManager.addProduct(products);
    }
}
