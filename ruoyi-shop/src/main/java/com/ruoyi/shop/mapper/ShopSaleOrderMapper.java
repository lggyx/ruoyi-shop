package com.ruoyi.shop.mapper;

import java.util.List;
import com.ruoyi.shop.domain.ShopSaleOrder;

/**
 * 销售订单Mapper接口
 * 
 * @author lggyx
 * @date 2025-12-05
 */
public interface ShopSaleOrderMapper 
{
    /**
     * 查询销售订单
     * 
     * @param orderId 销售订单主键
     * @return 销售订单
     */
    public ShopSaleOrder selectShopSaleOrderByOrderId(Long orderId);

    /**
     * 查询销售订单列表
     * 
     * @param shopSaleOrder 销售订单
     * @return 销售订单集合
     */
    public List<ShopSaleOrder> selectShopSaleOrderList(ShopSaleOrder shopSaleOrder);

    /**
     * 新增销售订单
     * 
     * @param shopSaleOrder 销售订单
     * @return 结果
     */
    public int insertShopSaleOrder(ShopSaleOrder shopSaleOrder);

    /**
     * 修改销售订单
     * 
     * @param shopSaleOrder 销售订单
     * @return 结果
     */
    public int updateShopSaleOrder(ShopSaleOrder shopSaleOrder);

    /**
     * 删除销售订单
     * 
     * @param orderId 销售订单主键
     * @return 结果
     */
    public int deleteShopSaleOrderByOrderId(Long orderId);

    /**
     * 批量删除销售订单
     * 
     * @param orderIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteShopSaleOrderByOrderIds(Long[] orderIds);
}
