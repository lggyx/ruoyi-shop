package com.ruoyi.shop.service;

import java.util.List;
import com.ruoyi.shop.domain.ShopProductSpec;

/**
 * 商品规格Service接口
 * 
 * @author lggyx
 * @date 2025-12-05
 */
public interface IShopProductSpecService 
{
    /**
     * 查询商品规格
     * 
     * @param specId 商品规格主键
     * @return 商品规格
     */
    public ShopProductSpec selectShopProductSpecBySpecId(Long specId);

    /**
     * 查询商品规格列表
     * 
     * @param shopProductSpec 商品规格
     * @return 商品规格集合
     */
    public List<ShopProductSpec> selectShopProductSpecList(ShopProductSpec shopProductSpec);

    /**
     * 新增商品规格
     * 
     * @param shopProductSpec 商品规格
     * @return 结果
     */
    public int insertShopProductSpec(ShopProductSpec shopProductSpec);

    /**
     * 修改商品规格
     * 
     * @param shopProductSpec 商品规格
     * @return 结果
     */
    public int updateShopProductSpec(ShopProductSpec shopProductSpec);

    /**
     * 批量删除商品规格
     * 
     * @param specIds 需要删除的商品规格主键集合
     * @return 结果
     */
    public int deleteShopProductSpecBySpecIds(Long[] specIds);

    /**
     * 删除商品规格信息
     * 
     * @param specId 商品规格主键
     * @return 结果
     */
    public int deleteShopProductSpecBySpecId(Long specId);
}
