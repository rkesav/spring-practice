package com.shopping.cart;

import com.shopping.discount.DiscountService;
import com.shopping.product.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
@Scope("prototype")
public class ShoppingCart {
    @Autowired
    DiscountService discountService;

    List<Product> products = new ArrayList<>();
    Boolean checkedOut = false;

    public void addProduct(Product product) {
        if (checkedOut) {
            throw new IllegalStateException("Cannot add more products to a checked out shopping cart");
        }
        products.add(product);
    }

    public BigDecimal checkOut() {
        Optional<BigDecimal> sum = products.stream().map(p -> discountService.applyDiscount(p)).reduce(BigDecimal::add);
        checkedOut = true;
        return sum.orElse(BigDecimal.ZERO);
    }

    @Override
    public String toString() {
        return products.toString();
    }
}
