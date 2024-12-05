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
        GeneratedCoinDto generatedCoinDto = service.generatedRandomCoins(readVendingMachineMoney());
        printGeneratedCoin(generatedCoinDto);

        generatedVendingMachineProduct();

        service.setClientInputMonyeToVendingMachine(readClientInputMoney());

        readClientPurchaseProduct();
    }

    private void readClientPurchaseProduct() {
        while (true) {
            try {
                int clientInputMoney = service.getClientInputMoney();
                inputView.printClientInputMoney(clientInputMoney);

                if (service.isPurchasePossible()) {
                    // 구매 가능하다면 투입금액 상품금액 만큼 빼고 재고 갱신해주기
                   String productName = inputView.readPurchaseProductName();
                   service.purchaseProduct(productName);
                    readClientPurchaseProduct();
               }

//               service.calculateChange();
            } catch (IllegalArgumentException e) {
                outputView.printExceptionMessage(e.getMessage());
            }
        }
    }

    private int readClientInputMoney() {
        while (true) {
            try {
                return inputView.readClientInputMoney();
            } catch (IllegalArgumentException e) {
                outputView.printExceptionMessage(e.getMessage());
            }
        }
    }

    private void generatedVendingMachineProduct() {
        while (true) {
            try {
                String products = readVendingMachineProduct();
                service.addProductToVendingMachine(products);
                return;
            } catch (IllegalArgumentException e) {
                outputView.printExceptionMessage(e.getMessage());
            }
        }
    }

    private int readVendingMachineMoney() {
        while (true) {
            try {
                return inputView.readVendingMachineMoney();
            } catch (IllegalArgumentException e) {
                outputView.printExceptionMessage(e.getMessage());
            }
        }
    }

    private String readVendingMachineProduct() {
        while (true) {
            try {
                return inputView.readVendingMachineProducts();
            } catch (IllegalArgumentException e) {
                outputView.printExceptionMessage(e.getMessage());
            }
        }
    }

    private void printGeneratedCoin(GeneratedCoinDto generatedCoinDto) {
        outputView.printGeneratedCoin(generatedCoinDto);
    }
}
