package com.ruoyi.shop.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.shop.mapper.ShopCategoryMapper;
import com.ruoyi.shop.domain.ShopCategory;
import com.ruoyi.shop.service.IShopCategoryService;

/**
 * 商品分类Service业务层处理
 * 
 * @author lggyx
 * @date 2025-12-05
 */
@Service
public class ShopCategoryServiceImpl implements IShopCategoryService 
{
    @Autowired
    private ShopCategoryMapper shopCategoryMapper;

    /**
     * 查询商品分类
     * 
     * @param categoryId 商品分类主键
     * @return 商品分类
     */
    @Override
    public ShopCategory selectShopCategoryByCategoryId(Long categoryId)
    {
        return shopCategoryMapper.selectShopCategoryByCategoryId(categoryId);
    }

    /**
     * 查询商品分类列表
     * 
     * @param shopCategory 商品分类
     * @return 商品分类
     */
    @Override
    public List<ShopCategory> selectShopCategoryList(ShopCategory shopCategory)
    {
        return shopCategoryMapper.selectShopCategoryList(shopCategory);
    }

    /**
     * 新增商品分类
     * 
     * @param shopCategory 商品分类
     * @return 结果
     */
    @Override
    public int insertShopCategory(ShopCategory shopCategory)
    {
        shopCategory.setCreateTime(DateUtils.getNowDate());
        return shopCategoryMapper.insertShopCategory(shopCategory);
    }

    /**
     * 修改商品分类
     * 
     * @param shopCategory 商品分类
     * @return 结果
     */
    @Override
    public int updateShopCategory(ShopCategory shopCategory)
    {
        shopCategory.setUpdateTime(DateUtils.getNowDate());
        return shopCategoryMapper.updateShopCategory(shopCategory);
    }

    /**
     * 批量删除商品分类
     * 
     * @param categoryIds 需要删除的商品分类主键
     * @return 结果
     */
    @Override
    public int deleteShopCategoryByCategoryIds(Long[] categoryIds)
    {
        return shopCategoryMapper.deleteShopCategoryByCategoryIds(categoryIds);
    }

    /**
     * 删除商品分类信息
     * 
     * @param categoryId 商品分类主键
     * @return 结果
     */
    @Override
    public int deleteShopCategoryByCategoryId(Long categoryId)
    {
        return shopCategoryMapper.deleteShopCategoryByCategoryId(categoryId);
    }
}
