package com.ruoyi.shop.mapper;

import java.util.List;
import com.ruoyi.shop.domain.ShopStock;

/**
 * 库存信息Mapper接口
 * 
 * @author lggyx
 * @date 2025-12-05
 */
public interface ShopStockMapper 
{
    /**
     * 查询库存信息
     * 
     * @param stockId 库存信息主键
     * @return 库存信息
     */
    public ShopStock selectShopStockByStockId(Long stockId);

    /**
     * 查询库存信息列表
     * 
     * @param shopStock 库存信息
     * @return 库存信息集合
     */
    public List<ShopStock> selectShopStockList(ShopStock shopStock);

    /**
     * 新增库存信息
     * 
     * @param shopStock 库存信息
     * @return 结果
     */
    public int insertShopStock(ShopStock shopStock);

    /**
     * 修改库存信息
     * 
     * @param shopStock 库存信息
     * @return 结果
     */
    public int updateShopStock(ShopStock shopStock);

    /**
     * 删除库存信息
     * 
     * @param stockId 库存信息主键
     * @return 结果
     */
    public int deleteShopStockByStockId(Long stockId);

    /**
     * 批量删除库存信息
     * 
     * @param stockIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteShopStockByStockIds(Long[] stockIds);
}
