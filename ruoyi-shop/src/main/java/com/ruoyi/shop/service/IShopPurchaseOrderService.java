package com.ruoyi.shop.service;

import java.util.List;
import com.ruoyi.shop.domain.ShopPurchaseOrder;

/**
 * 采购订单Service接口
 * 
 * @author lggyx
 * @date 2025-12-05
 */
public interface IShopPurchaseOrderService 
{
    /**
     * 查询采购订单
     * 
     * @param orderId 采购订单主键
     * @return 采购订单
     */
    public ShopPurchaseOrder selectShopPurchaseOrderByOrderId(Long orderId);

    /**
     * 查询采购订单列表
     * 
     * @param shopPurchaseOrder 采购订单
     * @return 采购订单集合
     */
    public List<ShopPurchaseOrder> selectShopPurchaseOrderList(ShopPurchaseOrder shopPurchaseOrder);

    /**
     * 新增采购订单
     * 
     * @param shopPurchaseOrder 采购订单
     * @return 结果
     */
    public int insertShopPurchaseOrder(ShopPurchaseOrder shopPurchaseOrder);

    /**
     * 修改采购订单
     * 
     * @param shopPurchaseOrder 采购订单
     * @return 结果
     */
    public int updateShopPurchaseOrder(ShopPurchaseOrder shopPurchaseOrder);

    /**
     * 批量删除采购订单
     * 
     * @param orderIds 需要删除的采购订单主键集合
     * @return 结果
     */
    public int deleteShopPurchaseOrderByOrderIds(Long[] orderIds);

    /**
     * 删除采购订单信息
     * 
     * @param orderId 采购订单主键
     * @return 结果
     */
    public int deleteShopPurchaseOrderByOrderId(Long orderId);
}
