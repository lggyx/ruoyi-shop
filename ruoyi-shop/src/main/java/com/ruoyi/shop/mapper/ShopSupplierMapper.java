package com.ruoyi.shop.mapper;

import java.util.List;
import com.ruoyi.shop.domain.ShopSupplier;

/**
 * 供应商信息Mapper接口
 * 
 * @author lggyx
 * @date 2025-12-05
 */
public interface ShopSupplierMapper 
{
    /**
     * 查询供应商信息
     * 
     * @param supplierId 供应商信息主键
     * @return 供应商信息
     */
    public ShopSupplier selectShopSupplierBySupplierId(Long supplierId);

    /**
     * 查询供应商信息列表
     * 
     * @param shopSupplier 供应商信息
     * @return 供应商信息集合
     */
    public List<ShopSupplier> selectShopSupplierList(ShopSupplier shopSupplier);

    /**
     * 新增供应商信息
     * 
     * @param shopSupplier 供应商信息
     * @return 结果
     */
    public int insertShopSupplier(ShopSupplier shopSupplier);

    /**
     * 修改供应商信息
     * 
     * @param shopSupplier 供应商信息
     * @return 结果
     */
    public int updateShopSupplier(ShopSupplier shopSupplier);

    /**
     * 删除供应商信息
     * 
     * @param supplierId 供应商信息主键
     * @return 结果
     */
    public int deleteShopSupplierBySupplierId(Long supplierId);

    /**
     * 批量删除供应商信息
     * 
     * @param supplierIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteShopSupplierBySupplierIds(Long[] supplierIds);
}
