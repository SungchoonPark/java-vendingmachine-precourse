package vendingmachine.controller;

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
        readVendingMachineMoney();
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
}
