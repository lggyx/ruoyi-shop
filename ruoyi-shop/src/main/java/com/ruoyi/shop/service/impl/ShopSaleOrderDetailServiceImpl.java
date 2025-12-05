package com.ruoyi.shop.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.shop.mapper.ShopSaleOrderDetailMapper;
import com.ruoyi.shop.domain.ShopSaleOrderDetail;
import com.ruoyi.shop.service.IShopSaleOrderDetailService;

/**
 * 销售订单明细Service业务层处理
 * 
 * @author lggyx
 * @date 2025-12-05
 */
@Service
public class ShopSaleOrderDetailServiceImpl implements IShopSaleOrderDetailService 
{
    @Autowired
    private ShopSaleOrderDetailMapper shopSaleOrderDetailMapper;

    /**
     * 查询销售订单明细
     * 
     * @param detailId 销售订单明细主键
     * @return 销售订单明细
     */
    @Override
    public ShopSaleOrderDetail selectShopSaleOrderDetailByDetailId(Long detailId)
    {
        return shopSaleOrderDetailMapper.selectShopSaleOrderDetailByDetailId(detailId);
    }

    /**
     * 查询销售订单明细列表
     * 
     * @param shopSaleOrderDetail 销售订单明细
     * @return 销售订单明细
     */
    @Override
    public List<ShopSaleOrderDetail> selectShopSaleOrderDetailList(ShopSaleOrderDetail shopSaleOrderDetail)
    {
        return shopSaleOrderDetailMapper.selectShopSaleOrderDetailList(shopSaleOrderDetail);
    }

    /**
     * 新增销售订单明细
     * 
     * @param shopSaleOrderDetail 销售订单明细
     * @return 结果
     */
    @Override
    public int insertShopSaleOrderDetail(ShopSaleOrderDetail shopSaleOrderDetail)
    {
        shopSaleOrderDetail.setCreateTime(DateUtils.getNowDate());
        return shopSaleOrderDetailMapper.insertShopSaleOrderDetail(shopSaleOrderDetail);
    }

    /**
     * 修改销售订单明细
     * 
     * @param shopSaleOrderDetail 销售订单明细
     * @return 结果
     */
    @Override
    public int updateShopSaleOrderDetail(ShopSaleOrderDetail shopSaleOrderDetail)
    {
        shopSaleOrderDetail.setUpdateTime(DateUtils.getNowDate());
        return shopSaleOrderDetailMapper.updateShopSaleOrderDetail(shopSaleOrderDetail);
    }

    /**
     * 批量删除销售订单明细
     * 
     * @param detailIds 需要删除的销售订单明细主键
     * @return 结果
     */
    @Override
    public int deleteShopSaleOrderDetailByDetailIds(Long[] detailIds)
    {
        return shopSaleOrderDetailMapper.deleteShopSaleOrderDetailByDetailIds(detailIds);
    }

    /**
     * 删除销售订单明细信息
     * 
     * @param detailId 销售订单明细主键
     * @return 结果
     */
    @Override
    public int deleteShopSaleOrderDetailByDetailId(Long detailId)
    {
        return shopSaleOrderDetailMapper.deleteShopSaleOrderDetailByDetailId(detailId);
    }
}
