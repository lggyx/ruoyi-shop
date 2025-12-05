package com.ruoyi.shop.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.shop.mapper.ShopProductMapper;
import com.ruoyi.shop.domain.ShopProduct;
import com.ruoyi.shop.service.IShopProductService;

/**
 * 商品信息Service业务层处理
 * 
 * @author lggyx
 * @date 2025-12-05
 */
@Service
public class ShopProductServiceImpl implements IShopProductService 
{
    @Autowired
    private ShopProductMapper shopProductMapper;

    /**
     * 查询商品信息
     * 
     * @param productId 商品信息主键
     * @return 商品信息
     */
    @Override
    public ShopProduct selectShopProductByProductId(Long productId)
    {
        return shopProductMapper.selectShopProductByProductId(productId);
    }

    /**
     * 查询商品信息列表
     * 
     * @param shopProduct 商品信息
     * @return 商品信息
     */
    @Override
    public List<ShopProduct> selectShopProductList(ShopProduct shopProduct)
    {
        return shopProductMapper.selectShopProductList(shopProduct);
    }

    /**
     * 新增商品信息
     * 
     * @param shopProduct 商品信息
     * @return 结果
     */
    @Override
    public int insertShopProduct(ShopProduct shopProduct)
    {
        shopProduct.setCreateTime(DateUtils.getNowDate());
        return shopProductMapper.insertShopProduct(shopProduct);
    }

    /**
     * 修改商品信息
     * 
     * @param shopProduct 商品信息
     * @return 结果
     */
    @Override
    public int updateShopProduct(ShopProduct shopProduct)
    {
        shopProduct.setUpdateTime(DateUtils.getNowDate());
        return shopProductMapper.updateShopProduct(shopProduct);
    }

    /**
     * 批量删除商品信息
     * 
     * @param productIds 需要删除的商品信息主键
     * @return 结果
     */
    @Override
    public int deleteShopProductByProductIds(Long[] productIds)
    {
        return shopProductMapper.deleteShopProductByProductIds(productIds);
    }

    /**
     * 删除商品信息信息
     * 
     * @param productId 商品信息主键
     * @return 结果
     */
    @Override
    public int deleteShopProductByProductId(Long productId)
    {
        return shopProductMapper.deleteShopProductByProductId(productId);
    }
}
