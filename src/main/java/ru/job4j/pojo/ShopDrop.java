package ru.job4j.pojo;

public class ShopDrop {
    public static Product[] delete(Product[] products, int index) {
        if (index < 0 || index >= products.length) {
            return products;
        }
        for (int i = index; i < products.length; i++) {
            Product product = products[i];
            if (i + 1 < products.length) {
                products[i] = products[i + 1];
            }
        }
        products[products.length - 1] = null;
        return products;
    }
}
