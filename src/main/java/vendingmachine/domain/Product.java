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

    public boolean isPurchasePossible(int clientMoney) {
        if (price > clientMoney) return false;

        return true;
    }

    public void checkExpensiveThenClientMoney(int clientMoney) {
        if (price > clientMoney) {
            throw new IllegalArgumentException(ExceptionMessage.EXPENSIVE_PRODUCT.getMessage());
        }
    }

    public Product compareProductName(String productName) {
        if (productName.equals(this.name)) return this;
        return null;
    }

    public int getPrice() {
        return price;
    }

    public int minusQuantity() {
        this.quantity = quantity - 1;
        return this.quantity;
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
