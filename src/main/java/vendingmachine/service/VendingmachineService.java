package vendingmachine.service;

import vendingmachine.domain.VendingMachine;
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
        // Todo : 자판기 최저 금액보다 작은 투입금액이 있거나, 재고가 없는 경우 false 리턴
        return vendingMachine.isPurchasePossible();
    }

    public void purchaseProduct(String productName) {
        vendingMachine.purchase(productName);
    }

    public int getClientInputMoney() {
        return vendingMachine.getClientInputMoney();
    }
}
