package vendingmachine;

import vendingmachine.controller.VendingmachineController;
import vendingmachine.service.VendingmachineService;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        VendingmachineController vendingmachineController = new VendingmachineController(
                new InputView(),
                new OutputView(),
                new VendingmachineService()
        );

        vendingmachineController.run();
    }
}
