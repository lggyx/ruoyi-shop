package com.ruoyi.shop.service;

import java.util.List;
import com.ruoyi.shop.domain.ShopVipCard;

/**
 * 会员卡信息Service接口
 * 
 * @author lggyx
 * @date 2025-12-05
 */
public interface IShopVipCardService 
{
    /**
     * 查询会员卡信息
     * 
     * @param cardId 会员卡信息主键
     * @return 会员卡信息
     */
    public ShopVipCard selectShopVipCardByCardId(Long cardId);

    /**
     * 查询会员卡信息列表
     * 
     * @param shopVipCard 会员卡信息
     * @return 会员卡信息集合
     */
    public List<ShopVipCard> selectShopVipCardList(ShopVipCard shopVipCard);

    /**
     * 新增会员卡信息
     * 
     * @param shopVipCard 会员卡信息
     * @return 结果
     */
    public int insertShopVipCard(ShopVipCard shopVipCard);

    /**
     * 修改会员卡信息
     * 
     * @param shopVipCard 会员卡信息
     * @return 结果
     */
    public int updateShopVipCard(ShopVipCard shopVipCard);

    /**
     * 批量删除会员卡信息
     * 
     * @param cardIds 需要删除的会员卡信息主键集合
     * @return 结果
     */
    public int deleteShopVipCardByCardIds(Long[] cardIds);

    /**
     * 删除会员卡信息信息
     * 
     * @param cardId 会员卡信息主键
     * @return 结果
     */
    public int deleteShopVipCardByCardId(Long cardId);
}
