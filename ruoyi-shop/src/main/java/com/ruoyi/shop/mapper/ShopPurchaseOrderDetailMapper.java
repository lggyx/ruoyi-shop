package com.ruoyi.shop.mapper;

import java.util.List;
import com.ruoyi.shop.domain.ShopPurchaseOrderDetail;

/**
 * 采购订单明细Mapper接口
 * 
 * @author lggyx
 * @date 2025-12-05
 */
public interface ShopPurchaseOrderDetailMapper 
{
    /**
     * 查询采购订单明细
     * 
     * @param detailId 采购订单明细主键
     * @return 采购订单明细
     */
    public ShopPurchaseOrderDetail selectShopPurchaseOrderDetailByDetailId(Long detailId);

    /**
     * 查询采购订单明细列表
     * 
     * @param shopPurchaseOrderDetail 采购订单明细
     * @return 采购订单明细集合
     */
    public List<ShopPurchaseOrderDetail> selectShopPurchaseOrderDetailList(ShopPurchaseOrderDetail shopPurchaseOrderDetail);

    /**
     * 新增采购订单明细
     * 
     * @param shopPurchaseOrderDetail 采购订单明细
     * @return 结果
     */
    public int insertShopPurchaseOrderDetail(ShopPurchaseOrderDetail shopPurchaseOrderDetail);

    /**
     * 修改采购订单明细
     * 
     * @param shopPurchaseOrderDetail 采购订单明细
     * @return 结果
     */
    public int updateShopPurchaseOrderDetail(ShopPurchaseOrderDetail shopPurchaseOrderDetail);

    /**
     * 删除采购订单明细
     * 
     * @param detailId 采购订单明细主键
     * @return 结果
     */
    public int deleteShopPurchaseOrderDetailByDetailId(Long detailId);

    /**
     * 批量删除采购订单明细
     * 
     * @param detailIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteShopPurchaseOrderDetailByDetailIds(Long[] detailIds);
}
