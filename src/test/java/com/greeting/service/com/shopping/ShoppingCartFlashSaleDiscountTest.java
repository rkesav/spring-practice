package com.greeting.service.com.shopping;

import com.shopping.product.Product;
import com.shopping.cart.ShoppingCart;
import com.shopping.config.ShoppingConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

@SpringJUnitConfig(classes = ShoppingConfig.class)
@ActiveProfiles("flash-sale")
public class ShoppingCartFlashSaleDiscountTest implements ApplicationContextAware {
    ApplicationContext context;

    @Test
    void testFlashSaleDiscount() {

        ShoppingCart shoppingCart1 = context.getBean(ShoppingCart.class);
        shoppingCart1.addProduct(new Product("biscuit", BigDecimal.valueOf(10)));
        shoppingCart1.addProduct(new Product("chocolate", BigDecimal.valueOf(20)));

        System.out.println(shoppingCart1);
        BigDecimal total1 = shoppingCart1.checkOut();
        assertEquals(BigDecimal.valueOf(24.0), total1);

        ShoppingCart shoppingCart2 = context.getBean(ShoppingCart.class);
        shoppingCart2.addProduct(new Product("fruits", BigDecimal.valueOf(5)));
        shoppingCart2.addProduct(new Product("vegetables", BigDecimal.valueOf(15)));

        System.out.println(shoppingCart2);
        BigDecimal total2 = shoppingCart2.checkOut();
        assertEquals(BigDecimal.valueOf(16.0), total2);

    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        context = applicationContext;
    }
}
