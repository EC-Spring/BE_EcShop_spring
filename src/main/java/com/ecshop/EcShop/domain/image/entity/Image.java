package com.ecshop.EcShop.domain.image.entity;

import com.ecshop.EcShop.domain.common.BaseTime;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "image")
public class Image extends BaseTime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="url")
    private String url;

    public Image(String url) {
        this.url = url;
    }
}
