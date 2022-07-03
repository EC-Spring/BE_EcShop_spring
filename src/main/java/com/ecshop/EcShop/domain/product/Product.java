package com.ecshop.EcShop.domain.product;


import com.ecshop.EcShop.domain.common.BaseTime;
import com.ecshop.EcShop.domain.image.Image;
import com.ecshop.EcShop.domain.size.Size;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
@Table
public class Product extends BaseTime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "brand", nullable = false)
    private String brand;

    @Column(name = "partNumber", nullable = false)
    private String partNumber;

    @Column(name = "price", nullable = false)
    private Integer price;

    @Column(name = "views", nullable = false)
    private Integer views;

    @Lob
    @Column(name = "info", nullable = false)
    private String info;

    @OneToOne
    @JoinColumn(name = "thumbnail_id")
    private Image thumbnailId;

    @OneToMany(mappedBy = "productId",cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Size> sizes;

    @Builder
    public Product(String name, String brand, String partNumber, Integer price, Integer views,
                   String info, Image thumbnailId) {
        this.name = name;
        this.brand = brand;
        this.partNumber = partNumber;
        this.price = price;
        this.views = views;
        this.info = info;
        this.thumbnailId = thumbnailId;
    }
}
