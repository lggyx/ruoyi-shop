package com.ruoyi.shop.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.shop.mapper.ShopSupplierMapper;
import com.ruoyi.shop.domain.ShopSupplier;
import com.ruoyi.shop.service.IShopSupplierService;

/**
 * 供应商信息Service业务层处理
 * 
 * @author lggyx
 * @date 2025-12-05
 */
@Service
public class ShopSupplierServiceImpl implements IShopSupplierService 
{
    @Autowired
    private ShopSupplierMapper shopSupplierMapper;

    /**
     * 查询供应商信息
     * 
     * @param supplierId 供应商信息主键
     * @return 供应商信息
     */
    @Override
    public ShopSupplier selectShopSupplierBySupplierId(Long supplierId)
    {
        return shopSupplierMapper.selectShopSupplierBySupplierId(supplierId);
    }

    /**
     * 查询供应商信息列表
     * 
     * @param shopSupplier 供应商信息
     * @return 供应商信息
     */
    @Override
    public List<ShopSupplier> selectShopSupplierList(ShopSupplier shopSupplier)
    {
        return shopSupplierMapper.selectShopSupplierList(shopSupplier);
    }

    /**
     * 新增供应商信息
     * 
     * @param shopSupplier 供应商信息
     * @return 结果
     */
    @Override
    public int insertShopSupplier(ShopSupplier shopSupplier)
    {
        shopSupplier.setCreateTime(DateUtils.getNowDate());
        return shopSupplierMapper.insertShopSupplier(shopSupplier);
    }

    /**
     * 修改供应商信息
     * 
     * @param shopSupplier 供应商信息
     * @return 结果
     */
    @Override
    public int updateShopSupplier(ShopSupplier shopSupplier)
    {
        shopSupplier.setUpdateTime(DateUtils.getNowDate());
        return shopSupplierMapper.updateShopSupplier(shopSupplier);
    }

    /**
     * 批量删除供应商信息
     * 
     * @param supplierIds 需要删除的供应商信息主键
     * @return 结果
     */
    @Override
    public int deleteShopSupplierBySupplierIds(Long[] supplierIds)
    {
        return shopSupplierMapper.deleteShopSupplierBySupplierIds(supplierIds);
    }

    /**
     * 删除供应商信息信息
     * 
     * @param supplierId 供应商信息主键
     * @return 结果
     */
    @Override
    public int deleteShopSupplierBySupplierId(Long supplierId)
    {
        return shopSupplierMapper.deleteShopSupplierBySupplierId(supplierId);
    }
}
