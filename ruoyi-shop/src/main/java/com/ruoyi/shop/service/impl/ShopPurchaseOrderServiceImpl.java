package com.ruoyi.shop.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.shop.mapper.ShopPurchaseOrderMapper;
import com.ruoyi.shop.domain.ShopPurchaseOrder;
import com.ruoyi.shop.service.IShopPurchaseOrderService;

/**
 * 采购订单Service业务层处理
 * 
 * @author lggyx
 * @date 2025-12-05
 */
@Service
public class ShopPurchaseOrderServiceImpl implements IShopPurchaseOrderService 
{
    @Autowired
    private ShopPurchaseOrderMapper shopPurchaseOrderMapper;

    /**
     * 查询采购订单
     * 
     * @param orderId 采购订单主键
     * @return 采购订单
     */
    @Override
    public ShopPurchaseOrder selectShopPurchaseOrderByOrderId(Long orderId)
    {
        return shopPurchaseOrderMapper.selectShopPurchaseOrderByOrderId(orderId);
    }

    /**
     * 查询采购订单列表
     * 
     * @param shopPurchaseOrder 采购订单
     * @return 采购订单
     */
    @Override
    public List<ShopPurchaseOrder> selectShopPurchaseOrderList(ShopPurchaseOrder shopPurchaseOrder)
    {
        return shopPurchaseOrderMapper.selectShopPurchaseOrderList(shopPurchaseOrder);
    }

    /**
     * 新增采购订单
     * 
     * @param shopPurchaseOrder 采购订单
     * @return 结果
     */
    @Override
    public int insertShopPurchaseOrder(ShopPurchaseOrder shopPurchaseOrder)
    {
        shopPurchaseOrder.setCreateTime(DateUtils.getNowDate());
        return shopPurchaseOrderMapper.insertShopPurchaseOrder(shopPurchaseOrder);
    }

    /**
     * 修改采购订单
     * 
     * @param shopPurchaseOrder 采购订单
     * @return 结果
     */
    @Override
    public int updateShopPurchaseOrder(ShopPurchaseOrder shopPurchaseOrder)
    {
        shopPurchaseOrder.setUpdateTime(DateUtils.getNowDate());
        return shopPurchaseOrderMapper.updateShopPurchaseOrder(shopPurchaseOrder);
    }

    /**
     * 批量删除采购订单
     * 
     * @param orderIds 需要删除的采购订单主键
     * @return 结果
     */
    @Override
    public int deleteShopPurchaseOrderByOrderIds(Long[] orderIds)
    {
        return shopPurchaseOrderMapper.deleteShopPurchaseOrderByOrderIds(orderIds);
    }

    /**
     * 删除采购订单信息
     * 
     * @param orderId 采购订单主键
     * @return 结果
     */
    @Override
    public int deleteShopPurchaseOrderByOrderId(Long orderId)
    {
        return shopPurchaseOrderMapper.deleteShopPurchaseOrderByOrderId(orderId);
    }
}
