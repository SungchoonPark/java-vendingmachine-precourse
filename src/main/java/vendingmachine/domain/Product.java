package vendingmachine.domain;

import vendingmachine.exception.ExceptionMessage;

public class Product {
    private final String name;
    private final int price;
    private int quantity;

    public Product(String name, int price, int quantity) {
        checkValidPrice(price);
        checkValidQuantity(quantity);
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    private void checkValidPrice(int price) {
        if (price < 100 || price % 10 != 0) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_PRODUCT_PRICE.getMessage());
        }
    }

    private void checkValidQuantity(int quantity) {
        if (quantity <= 0) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_PRODUCT_QUANTITY.getMessage());
        }
    }
}
