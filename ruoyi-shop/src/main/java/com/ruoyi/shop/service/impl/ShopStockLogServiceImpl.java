package com.ruoyi.shop.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.shop.mapper.ShopStockLogMapper;
import com.ruoyi.shop.domain.ShopStockLog;
import com.ruoyi.shop.service.IShopStockLogService;

/**
 * 库存流水Service业务层处理
 * 
 * @author ruoyi
 * @date 2025-12-05
 */
@Service
public class ShopStockLogServiceImpl implements IShopStockLogService 
{
    @Autowired
    private ShopStockLogMapper shopStockLogMapper;

    /**
     * 查询库存流水
     * 
     * @param logId 库存流水主键
     * @return 库存流水
     */
    @Override
    public ShopStockLog selectShopStockLogByLogId(Long logId)
    {
        return shopStockLogMapper.selectShopStockLogByLogId(logId);
    }

    /**
     * 查询库存流水列表
     * 
     * @param shopStockLog 库存流水
     * @return 库存流水
     */
    @Override
    public List<ShopStockLog> selectShopStockLogList(ShopStockLog shopStockLog)
    {
        return shopStockLogMapper.selectShopStockLogList(shopStockLog);
    }

    /**
     * 新增库存流水
     * 
     * @param shopStockLog 库存流水
     * @return 结果
     */
    @Override
    public int insertShopStockLog(ShopStockLog shopStockLog)
    {
        shopStockLog.setCreateTime(DateUtils.getNowDate());
        return shopStockLogMapper.insertShopStockLog(shopStockLog);
    }

    /**
     * 修改库存流水
     * 
     * @param shopStockLog 库存流水
     * @return 结果
     */
    @Override
    public int updateShopStockLog(ShopStockLog shopStockLog)
    {
        return shopStockLogMapper.updateShopStockLog(shopStockLog);
    }

    /**
     * 批量删除库存流水
     * 
     * @param logIds 需要删除的库存流水主键
     * @return 结果
     */
    @Override
    public int deleteShopStockLogByLogIds(Long[] logIds)
    {
        return shopStockLogMapper.deleteShopStockLogByLogIds(logIds);
    }

    /**
     * 删除库存流水信息
     * 
     * @param logId 库存流水主键
     * @return 结果
     */
    @Override
    public int deleteShopStockLogByLogId(Long logId)
    {
        return shopStockLogMapper.deleteShopStockLogByLogId(logId);
    }
}
