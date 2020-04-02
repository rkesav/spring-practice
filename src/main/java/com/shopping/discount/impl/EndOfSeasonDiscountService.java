package com.shopping.discount.impl;

import com.shopping.product.Product;
import com.shopping.discount.DiscountService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
@Profile("end-of-season")
public class EndOfSeasonDiscountService implements DiscountService {
    @Override
    public BigDecimal applyDiscount(Product product) {
        return product.getPrice().multiply(BigDecimal.valueOf(0.5));
    }
}
