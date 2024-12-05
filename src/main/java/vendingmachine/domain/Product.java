package vendingmachine.domain;

public class Product {
    private String name;
    private Integer price;
    private Integer amount;

    public Product(String name, Integer price, Integer amount) {
        this.name = name;
        this.price = price;
        this.amount = amount;
    }
}
