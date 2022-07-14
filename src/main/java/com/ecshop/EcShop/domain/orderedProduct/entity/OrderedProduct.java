package com.ecshop.EcShop.domain.orderedProduct.entity;


import com.ecshop.EcShop.domain.common.BaseTime;
import com.ecshop.EcShop.domain.order.entity.DeliveryOrder;
import com.ecshop.EcShop.domain.orderedProduct.OrderType;
import com.ecshop.EcShop.domain.product.entitiy.Product;
import com.ecshop.EcShop.domain.size.Size;
import com.ecshop.EcShop.domain.user.entitiy.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
@Table
public class OrderedProduct extends BaseTime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "order_type", nullable = false)
    @Enumerated(EnumType.STRING)
    private OrderType orderType;

    @OneToOne
    @PrimaryKeyJoinColumn(name = "product_id")
    private Product product;

    @OneToOne
    @PrimaryKeyJoinColumn(name = "size_id")
    private Size size;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User userId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "delivery_order_id")
    private DeliveryOrder deliveryOrderId;

    @Column(name = "quantity", nullable = false)
    private Integer quantity;

    @Builder
    public OrderedProduct(OrderType orderType, Product product, Size size, User userId, Integer quantity) {
        this.orderType = orderType;
        this.product = product;
        this.size = size;
        this.userId = userId;
        this.quantity = quantity;
    }

}
