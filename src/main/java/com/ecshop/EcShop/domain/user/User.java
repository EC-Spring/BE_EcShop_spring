package com.ecshop.EcShop.domain.user;

import com.ecshop.EcShop.domain.common.BaseTime;
import com.ecshop.EcShop.domain.order.DeliveryOrder;
import com.ecshop.EcShop.domain.orderedProduct.OrderedProduct;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "user")
public class User extends BaseTime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "role", nullable = false)
    @Enumerated(EnumType.STRING)
    private RoleType role;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "nick_name", nullable = false)
    private String nickName;

    @Column(name = "user_image", nullable = false)
    private String userImage;

    @Column(name = "phone", nullable = false)
    private String phoneNumber;

    @Column(name = "point", nullable = false)
    private int point;

    @OneToMany(mappedBy = "userId", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrderedProduct> cart;

    @OneToMany(mappedBy = "userId", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DeliveryOrder> deliveryOrders;

    @Builder
    User(String email, String nickName, String userImage, String phoneNumber) {
        this.email = email;
        this.nickName = nickName;
        this.userImage = userImage;
        this.phoneNumber = phoneNumber;
        this.role = RoleType.USER;
    }

//    @Column(name = "password", nullable = false)
//    private String password;


}
