package com.sunil.ecommerce.payment;

import com.sunil.ecommerce.customer.CustomerResponse;
import com.sunil.ecommerce.order.PaymentMethod;

import java.math.BigDecimal;

public record PaymentRequest(
        BigDecimal amount,
        PaymentMethod paymentMethod,
        Integer orderId,
        String orderReference,
        CustomerResponse customer
) {
}
