package vendingmachine.service;

import vendingmachine.domain.VendingMachine;
import vendingmachine.dto.ChangeDto;
import vendingmachine.dto.GeneratedCoinDto;

public class VendingmachineService {
    private final VendingMachine vendingMachine;

    public VendingmachineService() {
        this.vendingMachine = new VendingMachine();
    }

    public GeneratedCoinDto generatedRandomCoins(int haveMoney) {
        return vendingMachine.generatedVendingMachine(haveMoney);
    }

    public void addProductToVendingMachine(String products) {
        vendingMachine.addProducts(products);
    }

    public void setClientInputMonyeToVendingMachine(int clientInputMoney) {
        vendingMachine.setClientInputMoney(clientInputMoney);
    }

    public boolean isPurchasePossible() {
        return vendingMachine.isPurchasePossible();
    }

    public void purchaseProduct(String productName) {
        vendingMachine.purchase(productName);
    }

    public int getClientInputMoney() {
        return vendingMachine.getClientInputMoney();
    }

    public ChangeDto calculateChange() {
        return vendingMachine.calculateChange();
    }
}
