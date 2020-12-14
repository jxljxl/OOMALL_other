package cn.edu.xmu.goods.service;

import cn.edu.xmu.goods.model.dto.CartDTO;

import java.util.List;

/**
 * @Created at 12/13 20:53
 * @author zrh
 */
public interface GoodsServiceInterface {
    List<CartDTO> getCouponActivity(List<Long> goodsSkuIds);

    CartDTO getCouponActivityAlone(Long goodsSkuId);

    Boolean anbleChange(Long newGoodSkuId, Long goodSkuId);
}
