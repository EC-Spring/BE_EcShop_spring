package com.ecshop.EcShop.domain.size;

import com.ecshop.EcShop.domain.common.BaseTime;
import com.ecshop.EcShop.domain.product.Product;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "size")
public class Size extends BaseTime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "productsize")
    private String productSize;

    @Column(name = "stock")
    private Integer stock;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product productId;

    @Builder
    public Size(String productSize, Integer stock, Product productId) {
        this.productSize = productSize;
        this.stock = stock;
        this.productId = productId;
    }

}
