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
}
