package vendingmachine.controller;

import vendingmachine.dto.GeneratedCoinDto;
import vendingmachine.service.VendingmachineService;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

public class VendingmachineController {
    private final InputView inputView;
    public final OutputView outputView;
    private final VendingmachineService service;

    public VendingmachineController(InputView inputView, OutputView outputView, VendingmachineService service) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.service = service;
    }

    public void run() {
        int haveMoney = readVendingMachineMoney();

        GeneratedCoinDto generatedCoinDto = service.generatedRandomCoins(haveMoney);
        printGeneratedCoin(generatedCoinDto);
    }

    private int readVendingMachineMoney() {
        while(true) {
            try {
                return inputView.readVendingMachineMoney();
            } catch (IllegalArgumentException e) {
                outputView.printExceptionMessage(e.getMessage());
            }
        }
    }

    private void printGeneratedCoin(GeneratedCoinDto generatedCoinDto) {
        outputView.printGeneratedCoin(generatedCoinDto);
    }
}
