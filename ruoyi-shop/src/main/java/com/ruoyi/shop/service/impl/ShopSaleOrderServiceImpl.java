package com.ruoyi.shop.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.shop.mapper.ShopSaleOrderMapper;
import com.ruoyi.shop.domain.ShopSaleOrder;
import com.ruoyi.shop.service.IShopSaleOrderService;

/**
 * 销售订单Service业务层处理
 * 
 * @author lggyx
 * @date 2025-12-05
 */
@Service
public class ShopSaleOrderServiceImpl implements IShopSaleOrderService 
{
    @Autowired
    private ShopSaleOrderMapper shopSaleOrderMapper;

    /**
     * 查询销售订单
     * 
     * @param orderId 销售订单主键
     * @return 销售订单
     */
    @Override
    public ShopSaleOrder selectShopSaleOrderByOrderId(Long orderId)
    {
        return shopSaleOrderMapper.selectShopSaleOrderByOrderId(orderId);
    }

    /**
     * 查询销售订单列表
     * 
     * @param shopSaleOrder 销售订单
     * @return 销售订单
     */
    @Override
    public List<ShopSaleOrder> selectShopSaleOrderList(ShopSaleOrder shopSaleOrder)
    {
        return shopSaleOrderMapper.selectShopSaleOrderList(shopSaleOrder);
    }

    /**
     * 新增销售订单
     * 
     * @param shopSaleOrder 销售订单
     * @return 结果
     */
    @Override
    public int insertShopSaleOrder(ShopSaleOrder shopSaleOrder)
    {
        shopSaleOrder.setCreateTime(DateUtils.getNowDate());
        return shopSaleOrderMapper.insertShopSaleOrder(shopSaleOrder);
    }

    /**
     * 修改销售订单
     * 
     * @param shopSaleOrder 销售订单
     * @return 结果
     */
    @Override
    public int updateShopSaleOrder(ShopSaleOrder shopSaleOrder)
    {
        shopSaleOrder.setUpdateTime(DateUtils.getNowDate());
        return shopSaleOrderMapper.updateShopSaleOrder(shopSaleOrder);
    }

    /**
     * 批量删除销售订单
     * 
     * @param orderIds 需要删除的销售订单主键
     * @return 结果
     */
    @Override
    public int deleteShopSaleOrderByOrderIds(Long[] orderIds)
    {
        return shopSaleOrderMapper.deleteShopSaleOrderByOrderIds(orderIds);
    }

    /**
     * 删除销售订单信息
     * 
     * @param orderId 销售订单主键
     * @return 结果
     */
    @Override
    public int deleteShopSaleOrderByOrderId(Long orderId)
    {
        return shopSaleOrderMapper.deleteShopSaleOrderByOrderId(orderId);
    }
}
