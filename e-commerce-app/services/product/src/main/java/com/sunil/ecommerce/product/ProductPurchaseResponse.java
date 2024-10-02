package com.sunil.ecommerce.product;

import java.math.BigDecimal;

public record ProductPurchaseResponse(

        Integer productId,

        String name,

        String description,

        BigDecimal price,

        Integer quantity
) {
}
