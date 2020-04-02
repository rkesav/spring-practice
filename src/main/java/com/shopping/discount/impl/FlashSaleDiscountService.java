package com.shopping.discount.impl;

import com.shopping.product.Product;
import com.shopping.discount.DiscountService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
@Profile("flash-sale")
public class FlashSaleDiscountService implements DiscountService {
    @Override
    public BigDecimal applyDiscount(Product product) {
        return product.getPrice().subtract(product.getPrice().multiply(BigDecimal.valueOf(0.2)));
    }
}
