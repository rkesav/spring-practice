package com.shopping;

import com.shopping.cart.ShoppingCart;
import com.shopping.config.ShoppingConfig;
import com.shopping.product.Product;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.math.BigDecimal;

public class Application {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

        context.getEnvironment().setActiveProfiles("end-of-season");
        context.register(ShoppingConfig.class);
        context.refresh();

        ShoppingCart shoppingCart1 = context.getBean(ShoppingCart.class);
        shoppingCart1.addProduct(new Product("biscuit", BigDecimal.valueOf(10)));
        shoppingCart1.addProduct(new Product("chocolate", BigDecimal.valueOf(20)));

        System.out.println(shoppingCart1);
        System.out.println(shoppingCart1.checkOut());

        ((ConfigurableApplicationContext) context).close();
    }
}
