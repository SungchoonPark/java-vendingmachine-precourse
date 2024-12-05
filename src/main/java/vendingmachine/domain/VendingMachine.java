package vendingmachine.domain;

import vendingmachine.dto.ChangeDto;
import vendingmachine.dto.GeneratedCoinDto;

public class VendingMachine {
    private final CoinManager coinManager;
    private final ProductManager productManager;
    private int clientInputMoney;

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

    public void setClientInputMoney(int clientInputMoney) {
        this.clientInputMoney = clientInputMoney;
    }

    public boolean isPurchasePossible() {
        return productManager.isPurchasePossible(clientInputMoney);
    }

    public void purchase(String productName) {
        int productPrice = productManager.purchaseProductByName(productName, clientInputMoney);
        minusClientMoney(productPrice);
    }

    private void minusClientMoney(int productPrice) {
        this.clientInputMoney -= productPrice;
    }

    public int getClientInputMoney() {
        return clientInputMoney;
    }

    public ChangeDto calculateChange() {
        return coinManager.generateChange(clientInputMoney);
    }
}
