package com.ruoyi.shop.mapper;

import java.util.List;
import com.ruoyi.shop.domain.ShopProductSpec;

/**
 * 商品规格Mapper接口
 * 
 * @author lggyx
 * @date 2025-12-05
 */
public interface ShopProductSpecMapper 
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
     * 删除商品规格
     * 
     * @param specId 商品规格主键
     * @return 结果
     */
    public int deleteShopProductSpecBySpecId(Long specId);

    /**
     * 批量删除商品规格
     * 
     * @param specIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteShopProductSpecBySpecIds(Long[] specIds);
}
