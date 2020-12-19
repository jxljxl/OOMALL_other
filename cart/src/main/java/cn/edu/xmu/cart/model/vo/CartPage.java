package cn.edu.xmu.cart.model.vo;

import cn.edu.xmu.cart.model.bo.Cart;
import cn.edu.xmu.goods.dto.CouponActivityDTO;


import java.time.LocalDateTime;
import java.util.List;

public class CartPage{
    private Long id;
    private Long goodsSkuId;
    private String skuName;
    private Integer quantity;
    private Long price;
    private List<CouponActivityDTO> couponActivity;
    private LocalDateTime gmtCreate;
    private LocalDateTime gmtModified;

    public CartPage(Cart bo){
        this.id=bo.getId();
        this.skuName=bo.getSkuName();
        this.goodsSkuId=bo.getGoodsSkuId();
        this.quantity=bo.getQuantity();
        this.price=bo.getPrice();
        this.couponActivity=bo.getCouponActivity();
        this.gmtCreate=bo.getGmtCreate();
        this.gmtModified=bo.getGmtModified();
    }

}
