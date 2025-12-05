package com.ruoyi.shop.mapper;

import java.util.List;
import com.ruoyi.shop.domain.ShopStockLog;

/**
 * 库存流水Mapper接口
 * 
 * @author ruoyi
 * @date 2025-12-05
 */
public interface ShopStockLogMapper 
{
    /**
     * 查询库存流水
     * 
     * @param logId 库存流水主键
     * @return 库存流水
     */
    public ShopStockLog selectShopStockLogByLogId(Long logId);

    /**
     * 查询库存流水列表
     * 
     * @param shopStockLog 库存流水
     * @return 库存流水集合
     */
    public List<ShopStockLog> selectShopStockLogList(ShopStockLog shopStockLog);

    /**
     * 新增库存流水
     * 
     * @param shopStockLog 库存流水
     * @return 结果
     */
    public int insertShopStockLog(ShopStockLog shopStockLog);

    /**
     * 修改库存流水
     * 
     * @param shopStockLog 库存流水
     * @return 结果
     */
    public int updateShopStockLog(ShopStockLog shopStockLog);

    /**
     * 删除库存流水
     * 
     * @param logId 库存流水主键
     * @return 结果
     */
    public int deleteShopStockLogByLogId(Long logId);

    /**
     * 批量删除库存流水
     * 
     * @param logIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteShopStockLogByLogIds(Long[] logIds);
}
