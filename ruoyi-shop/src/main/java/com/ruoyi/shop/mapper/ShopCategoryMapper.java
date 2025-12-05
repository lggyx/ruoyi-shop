package com.ruoyi.shop.mapper;

import java.util.List;
import com.ruoyi.shop.domain.ShopCategory;

/**
 * 商品分类Mapper接口
 * 
 * @author lggyx
 * @date 2025-12-05
 */
public interface ShopCategoryMapper 
{
    /**
     * 查询商品分类
     * 
     * @param categoryId 商品分类主键
     * @return 商品分类
     */
    public ShopCategory selectShopCategoryByCategoryId(Long categoryId);

    /**
     * 查询商品分类列表
     * 
     * @param shopCategory 商品分类
     * @return 商品分类集合
     */
    public List<ShopCategory> selectShopCategoryList(ShopCategory shopCategory);

    /**
     * 新增商品分类
     * 
     * @param shopCategory 商品分类
     * @return 结果
     */
    public int insertShopCategory(ShopCategory shopCategory);

    /**
     * 修改商品分类
     * 
     * @param shopCategory 商品分类
     * @return 结果
     */
    public int updateShopCategory(ShopCategory shopCategory);

    /**
     * 删除商品分类
     * 
     * @param categoryId 商品分类主键
     * @return 结果
     */
    public int deleteShopCategoryByCategoryId(Long categoryId);

    /**
     * 批量删除商品分类
     * 
     * @param categoryIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteShopCategoryByCategoryIds(Long[] categoryIds);
}
