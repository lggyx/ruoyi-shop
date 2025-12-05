package com.ruoyi.shop.mapper;

import java.util.List;
import com.ruoyi.shop.domain.ShopSaleOrderDetail;

/**
 * 销售订单明细Mapper接口
 * 
 * @author lggyx
 * @date 2025-12-05
 */
public interface ShopSaleOrderDetailMapper 
{
    /**
     * 查询销售订单明细
     * 
     * @param detailId 销售订单明细主键
     * @return 销售订单明细
     */
    public ShopSaleOrderDetail selectShopSaleOrderDetailByDetailId(Long detailId);

    /**
     * 查询销售订单明细列表
     * 
     * @param shopSaleOrderDetail 销售订单明细
     * @return 销售订单明细集合
     */
    public List<ShopSaleOrderDetail> selectShopSaleOrderDetailList(ShopSaleOrderDetail shopSaleOrderDetail);

    /**
     * 新增销售订单明细
     * 
     * @param shopSaleOrderDetail 销售订单明细
     * @return 结果
     */
    public int insertShopSaleOrderDetail(ShopSaleOrderDetail shopSaleOrderDetail);

    /**
     * 修改销售订单明细
     * 
     * @param shopSaleOrderDetail 销售订单明细
     * @return 结果
     */
    public int updateShopSaleOrderDetail(ShopSaleOrderDetail shopSaleOrderDetail);

    /**
     * 删除销售订单明细
     * 
     * @param detailId 销售订单明细主键
     * @return 结果
     */
    public int deleteShopSaleOrderDetailByDetailId(Long detailId);

    /**
     * 批量删除销售订单明细
     * 
     * @param detailIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteShopSaleOrderDetailByDetailIds(Long[] detailIds);
}
