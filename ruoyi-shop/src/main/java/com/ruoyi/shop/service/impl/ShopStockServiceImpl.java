package com.ruoyi.shop.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.shop.mapper.ShopStockMapper;
import com.ruoyi.shop.domain.ShopStock;
import com.ruoyi.shop.service.IShopStockService;

/**
 * 库存信息Service业务层处理
 * 
 * @author lggyx
 * @date 2025-12-05
 */
@Service
public class ShopStockServiceImpl implements IShopStockService 
{
    @Autowired
    private ShopStockMapper shopStockMapper;

    /**
     * 查询库存信息
     * 
     * @param stockId 库存信息主键
     * @return 库存信息
     */
    @Override
    public ShopStock selectShopStockByStockId(Long stockId)
    {
        return shopStockMapper.selectShopStockByStockId(stockId);
    }

    /**
     * 查询库存信息列表
     * 
     * @param shopStock 库存信息
     * @return 库存信息
     */
    @Override
    public List<ShopStock> selectShopStockList(ShopStock shopStock)
    {
        return shopStockMapper.selectShopStockList(shopStock);
    }

    /**
     * 新增库存信息
     * 
     * @param shopStock 库存信息
     * @return 结果
     */
    @Override
    public int insertShopStock(ShopStock shopStock)
    {
        shopStock.setCreateTime(DateUtils.getNowDate());
        return shopStockMapper.insertShopStock(shopStock);
    }

    /**
     * 修改库存信息
     * 
     * @param shopStock 库存信息
     * @return 结果
     */
    @Override
    public int updateShopStock(ShopStock shopStock)
    {
        shopStock.setUpdateTime(DateUtils.getNowDate());
        return shopStockMapper.updateShopStock(shopStock);
    }

    /**
     * 批量删除库存信息
     * 
     * @param stockIds 需要删除的库存信息主键
     * @return 结果
     */
    @Override
    public int deleteShopStockByStockIds(Long[] stockIds)
    {
        return shopStockMapper.deleteShopStockByStockIds(stockIds);
    }

    /**
     * 删除库存信息信息
     * 
     * @param stockId 库存信息主键
     * @return 结果
     */
    @Override
    public int deleteShopStockByStockId(Long stockId)
    {
        return shopStockMapper.deleteShopStockByStockId(stockId);
    }
}
