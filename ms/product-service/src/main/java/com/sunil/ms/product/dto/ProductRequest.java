package com.sunil.ms.product.dto;

import java.math.BigDecimal;

public record ProductRequest(
        Integer id,
        String name,
        String description,
        BigDecimal price
) {
}
