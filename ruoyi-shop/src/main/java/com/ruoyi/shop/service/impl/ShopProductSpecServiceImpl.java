package com.ruoyi.shop.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.shop.mapper.ShopProductSpecMapper;
import com.ruoyi.shop.domain.ShopProductSpec;
import com.ruoyi.shop.service.IShopProductSpecService;

/**
 * 商品规格Service业务层处理
 * 
 * @author lggyx
 * @date 2025-12-05
 */
@Service
public class ShopProductSpecServiceImpl implements IShopProductSpecService 
{
    @Autowired
    private ShopProductSpecMapper shopProductSpecMapper;

    /**
     * 查询商品规格
     * 
     * @param specId 商品规格主键
     * @return 商品规格
     */
    @Override
    public ShopProductSpec selectShopProductSpecBySpecId(Long specId)
    {
        return shopProductSpecMapper.selectShopProductSpecBySpecId(specId);
    }

    /**
     * 查询商品规格列表
     * 
     * @param shopProductSpec 商品规格
     * @return 商品规格
     */
    @Override
    public List<ShopProductSpec> selectShopProductSpecList(ShopProductSpec shopProductSpec)
    {
        return shopProductSpecMapper.selectShopProductSpecList(shopProductSpec);
    }

    /**
     * 新增商品规格
     * 
     * @param shopProductSpec 商品规格
     * @return 结果
     */
    @Override
    public int insertShopProductSpec(ShopProductSpec shopProductSpec)
    {
        shopProductSpec.setCreateTime(DateUtils.getNowDate());
        return shopProductSpecMapper.insertShopProductSpec(shopProductSpec);
    }

    /**
     * 修改商品规格
     * 
     * @param shopProductSpec 商品规格
     * @return 结果
     */
    @Override
    public int updateShopProductSpec(ShopProductSpec shopProductSpec)
    {
        shopProductSpec.setUpdateTime(DateUtils.getNowDate());
        return shopProductSpecMapper.updateShopProductSpec(shopProductSpec);
    }

    /**
     * 批量删除商品规格
     * 
     * @param specIds 需要删除的商品规格主键
     * @return 结果
     */
    @Override
    public int deleteShopProductSpecBySpecIds(Long[] specIds)
    {
        return shopProductSpecMapper.deleteShopProductSpecBySpecIds(specIds);
    }

    /**
     * 删除商品规格信息
     * 
     * @param specId 商品规格主键
     * @return 结果
     */
    @Override
    public int deleteShopProductSpecBySpecId(Long specId)
    {
        return shopProductSpecMapper.deleteShopProductSpecBySpecId(specId);
    }
}
