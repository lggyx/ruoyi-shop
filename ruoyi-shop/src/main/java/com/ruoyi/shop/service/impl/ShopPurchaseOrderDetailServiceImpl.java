package com.ruoyi.shop.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.shop.mapper.ShopPurchaseOrderDetailMapper;
import com.ruoyi.shop.domain.ShopPurchaseOrderDetail;
import com.ruoyi.shop.service.IShopPurchaseOrderDetailService;

/**
 * 采购订单明细Service业务层处理
 * 
 * @author lggyx
 * @date 2025-12-05
 */
@Service
public class ShopPurchaseOrderDetailServiceImpl implements IShopPurchaseOrderDetailService 
{
    @Autowired
    private ShopPurchaseOrderDetailMapper shopPurchaseOrderDetailMapper;

    /**
     * 查询采购订单明细
     * 
     * @param detailId 采购订单明细主键
     * @return 采购订单明细
     */
    @Override
    public ShopPurchaseOrderDetail selectShopPurchaseOrderDetailByDetailId(Long detailId)
    {
        return shopPurchaseOrderDetailMapper.selectShopPurchaseOrderDetailByDetailId(detailId);
    }

    /**
     * 查询采购订单明细列表
     * 
     * @param shopPurchaseOrderDetail 采购订单明细
     * @return 采购订单明细
     */
    @Override
    public List<ShopPurchaseOrderDetail> selectShopPurchaseOrderDetailList(ShopPurchaseOrderDetail shopPurchaseOrderDetail)
    {
        return shopPurchaseOrderDetailMapper.selectShopPurchaseOrderDetailList(shopPurchaseOrderDetail);
    }

    /**
     * 新增采购订单明细
     * 
     * @param shopPurchaseOrderDetail 采购订单明细
     * @return 结果
     */
    @Override
    public int insertShopPurchaseOrderDetail(ShopPurchaseOrderDetail shopPurchaseOrderDetail)
    {
        shopPurchaseOrderDetail.setCreateTime(DateUtils.getNowDate());
        return shopPurchaseOrderDetailMapper.insertShopPurchaseOrderDetail(shopPurchaseOrderDetail);
    }

    /**
     * 修改采购订单明细
     * 
     * @param shopPurchaseOrderDetail 采购订单明细
     * @return 结果
     */
    @Override
    public int updateShopPurchaseOrderDetail(ShopPurchaseOrderDetail shopPurchaseOrderDetail)
    {
        shopPurchaseOrderDetail.setUpdateTime(DateUtils.getNowDate());
        return shopPurchaseOrderDetailMapper.updateShopPurchaseOrderDetail(shopPurchaseOrderDetail);
    }

    /**
     * 批量删除采购订单明细
     * 
     * @param detailIds 需要删除的采购订单明细主键
     * @return 结果
     */
    @Override
    public int deleteShopPurchaseOrderDetailByDetailIds(Long[] detailIds)
    {
        return shopPurchaseOrderDetailMapper.deleteShopPurchaseOrderDetailByDetailIds(detailIds);
    }

    /**
     * 删除采购订单明细信息
     * 
     * @param detailId 采购订单明细主键
     * @return 结果
     */
    @Override
    public int deleteShopPurchaseOrderDetailByDetailId(Long detailId)
    {
        return shopPurchaseOrderDetailMapper.deleteShopPurchaseOrderDetailByDetailId(detailId);
    }
}
