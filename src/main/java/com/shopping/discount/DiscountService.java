package com.shopping.discount;

import com.shopping.product.Product;

import java.math.BigDecimal;

public interface DiscountService {
    BigDecimal applyDiscount(Product product);
}
