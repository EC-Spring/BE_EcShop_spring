package com.ecshop.EcShop.domain.order;

import com.ecshop.EcShop.domain.common.BaseTime;
import com.ecshop.EcShop.domain.orderedProduct.OrderedProduct;
import com.ecshop.EcShop.domain.user.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "delivery_order")
public class DeliveryOrder extends BaseTime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "order_number", nullable = false, unique = true)
    private Integer orderNumber;

    @Column(name = "cost", nullable = false)
    private Integer cost;
    //
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User userId;

    @OneToMany(mappedBy = "deliveryOrderId",cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrderedProduct> orderedProducts;

    @Builder
    public DeliveryOrder(Integer orderNumber, Integer cost) {
        this.orderNumber = orderNumber;
        this.cost = cost;
    }
}
