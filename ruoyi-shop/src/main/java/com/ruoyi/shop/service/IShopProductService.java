package com.ruoyi.shop.service;

import java.util.List;
import com.ruoyi.shop.domain.ShopProduct;

/**
 * 商品信息Service接口
 * 
 * @author lggyx
 * @date 2025-12-05
 */
public interface IShopProductService 
{
    /**
     * 查询商品信息
     * 
     * @param productId 商品信息主键
     * @return 商品信息
     */
    public ShopProduct selectShopProductByProductId(Long productId);

    /**
     * 查询商品信息列表
     * 
     * @param shopProduct 商品信息
     * @return 商品信息集合
     */
    public List<ShopProduct> selectShopProductList(ShopProduct shopProduct);

    /**
     * 新增商品信息
     * 
     * @param shopProduct 商品信息
     * @return 结果
     */
    public int insertShopProduct(ShopProduct shopProduct);

    /**
     * 修改商品信息
     * 
     * @param shopProduct 商品信息
     * @return 结果
     */
    public int updateShopProduct(ShopProduct shopProduct);

    /**
     * 批量删除商品信息
     * 
     * @param productIds 需要删除的商品信息主键集合
     * @return 结果
     */
    public int deleteShopProductByProductIds(Long[] productIds);

    /**
     * 删除商品信息信息
     * 
     * @param productId 商品信息主键
     * @return 结果
     */
    public int deleteShopProductByProductId(Long productId);
}
