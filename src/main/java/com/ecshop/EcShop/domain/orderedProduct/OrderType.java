package com.ecshop.EcShop.domain.orderedProduct;

public enum OrderType {
    CART("CART"),
    BEFORE_REMITTANCE("BEFORE_REMITTANCE"),
    AFTER_REMITTANCE("AFTER_REMITTANCE"),
    PREPARING_FOR_DELEVERY("PREPARING_FOR_DELEVERY"),
    SHIPPING("SHIPPING"),
    DELEVERY_COMPLETED("DELEVERY_COMPLETED");

    private final String orderType;

    OrderType(String orderType) {
        this.orderType = orderType;
    }

}
