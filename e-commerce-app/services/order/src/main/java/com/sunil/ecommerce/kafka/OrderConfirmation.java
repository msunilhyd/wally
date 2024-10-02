package com.sunil.ecommerce.kafka;

import com.sunil.ecommerce.customer.CustomerResponse;
import com.sunil.ecommerce.order.PaymentMethod;
import com.sunil.ecommerce.product.PurchaseResponse;

import java.math.BigDecimal;
import java.util.List;

public record OrderConfirmation(

        String orderReference,
        BigDecimal totalAmount,
        PaymentMethod paymentMethod,
        CustomerResponse customer,
        List<PurchaseResponse> products
) {
}
