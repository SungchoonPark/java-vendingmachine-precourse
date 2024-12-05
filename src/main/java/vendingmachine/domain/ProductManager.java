package vendingmachine.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ProductManager {
    private  List<Product> products;

    private static final String REGEX = "\\[([\\w가-힣]+),(\\d+),(\\d+)\\]";

    public ProductManager() {
        this.products = new ArrayList<>();
    }

    public void addProduct(String products) {
        String[] productList = products.split(";");

        Pattern pattern = Pattern.compile(REGEX);
        for (String product : productList) {
            Matcher matcher = pattern.matcher(product);

            if (matcher.matches()) {
                String name = matcher.group(1);
                int price = Integer.parseInt(matcher.group(2));
                int quantity = Integer.parseInt(matcher.group(3));

                this.products.add(new Product(name, price, quantity));
            }
        }
    }
}
