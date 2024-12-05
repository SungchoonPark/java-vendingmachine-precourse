package vendingmachine.domain;

import vendingmachine.exception.ExceptionMessage;

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

    private boolean isProductExist() {
        return products.size() != 0;
    }

    public boolean isPurchasePossible(int clientInputMoney) {
        if (!isProductExist())  return false;

        boolean isPurchasePossible = false;
        for (Product product : products) {
            if(product.isPurchasePossible(clientInputMoney)) isPurchasePossible = true;
        }

        return isPurchasePossible;
    }

    public int purchaseProductByName(String productName, int clientInputMoney) {
        Product findProduct = findProductByName(productName);
        findProduct.checkExpensiveThenClientMoney(clientInputMoney);
        int quantity = findProduct.minusQuantity();
        if (quantity == 0) products.remove(findProduct);
        return findProduct.getPrice();
    }

    public Product findProductByName(String productName) {
        for (Product product : products) {
            Product result = product.compareProductName(productName);
            if (result != null) return result;
        }
        throw new IllegalArgumentException(ExceptionMessage.NOT_EXIST_PRODUCT.getMessage());
    }
}
