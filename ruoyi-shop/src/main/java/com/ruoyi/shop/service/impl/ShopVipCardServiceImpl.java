package com.ruoyi.shop.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.shop.mapper.ShopVipCardMapper;
import com.ruoyi.shop.domain.ShopVipCard;
import com.ruoyi.shop.service.IShopVipCardService;

/**
 * 会员卡信息Service业务层处理
 * 
 * @author lggyx
 * @date 2025-12-05
 */
@Service
public class ShopVipCardServiceImpl implements IShopVipCardService 
{
    @Autowired
    private ShopVipCardMapper shopVipCardMapper;

    /**
     * 查询会员卡信息
     * 
     * @param cardId 会员卡信息主键
     * @return 会员卡信息
     */
    @Override
    public ShopVipCard selectShopVipCardByCardId(Long cardId)
    {
        return shopVipCardMapper.selectShopVipCardByCardId(cardId);
    }

    /**
     * 查询会员卡信息列表
     * 
     * @param shopVipCard 会员卡信息
     * @return 会员卡信息
     */
    @Override
    public List<ShopVipCard> selectShopVipCardList(ShopVipCard shopVipCard)
    {
        return shopVipCardMapper.selectShopVipCardList(shopVipCard);
    }

    /**
     * 新增会员卡信息
     * 
     * @param shopVipCard 会员卡信息
     * @return 结果
     */
    @Override
    public int insertShopVipCard(ShopVipCard shopVipCard)
    {
        shopVipCard.setCreateTime(DateUtils.getNowDate());
        return shopVipCardMapper.insertShopVipCard(shopVipCard);
    }

    /**
     * 修改会员卡信息
     * 
     * @param shopVipCard 会员卡信息
     * @return 结果
     */
    @Override
    public int updateShopVipCard(ShopVipCard shopVipCard)
    {
        shopVipCard.setUpdateTime(DateUtils.getNowDate());
        return shopVipCardMapper.updateShopVipCard(shopVipCard);
    }

    /**
     * 批量删除会员卡信息
     * 
     * @param cardIds 需要删除的会员卡信息主键
     * @return 结果
     */
    @Override
    public int deleteShopVipCardByCardIds(Long[] cardIds)
    {
        return shopVipCardMapper.deleteShopVipCardByCardIds(cardIds);
    }

    /**
     * 删除会员卡信息信息
     * 
     * @param cardId 会员卡信息主键
     * @return 结果
     */
    @Override
    public int deleteShopVipCardByCardId(Long cardId)
    {
        return shopVipCardMapper.deleteShopVipCardByCardId(cardId);
    }
}
