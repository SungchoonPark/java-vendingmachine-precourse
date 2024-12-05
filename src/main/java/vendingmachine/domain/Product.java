package vendingmachine.domain;

public class Product {
    private String name;
    private Integer price;
    private Integer quantity;

    public Product(String name, Integer price, Integer quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    // Todo : price가 100원 이상인지, 10원으로 나누어 떨어지는지 확인해야함.


    public String getName() {
        return name;
    }
}
