package com.ruoyi.shop.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.shop.mapper.ShopMemberMapper;
import com.ruoyi.shop.domain.ShopMember;
import com.ruoyi.shop.service.IShopMemberService;

/**
 * 会员信息Service业务层处理
 * 
 * @author lggyx
 * @date 2025-12-05
 */
@Service
public class ShopMemberServiceImpl implements IShopMemberService 
{
    @Autowired
    private ShopMemberMapper shopMemberMapper;

    /**
     * 查询会员信息
     * 
     * @param memberId 会员信息主键
     * @return 会员信息
     */
    @Override
    public ShopMember selectShopMemberByMemberId(Long memberId)
    {
        return shopMemberMapper.selectShopMemberByMemberId(memberId);
    }

    /**
     * 查询会员信息列表
     * 
     * @param shopMember 会员信息
     * @return 会员信息
     */
    @Override
    public List<ShopMember> selectShopMemberList(ShopMember shopMember)
    {
        return shopMemberMapper.selectShopMemberList(shopMember);
    }

    /**
     * 新增会员信息
     * 
     * @param shopMember 会员信息
     * @return 结果
     */
    @Override
    public int insertShopMember(ShopMember shopMember)
    {
        shopMember.setCreateTime(DateUtils.getNowDate());
        return shopMemberMapper.insertShopMember(shopMember);
    }

    /**
     * 修改会员信息
     * 
     * @param shopMember 会员信息
     * @return 结果
     */
    @Override
    public int updateShopMember(ShopMember shopMember)
    {
        shopMember.setUpdateTime(DateUtils.getNowDate());
        return shopMemberMapper.updateShopMember(shopMember);
    }

    /**
     * 批量删除会员信息
     * 
     * @param memberIds 需要删除的会员信息主键
     * @return 结果
     */
    @Override
    public int deleteShopMemberByMemberIds(Long[] memberIds)
    {
        return shopMemberMapper.deleteShopMemberByMemberIds(memberIds);
    }

    /**
     * 删除会员信息信息
     * 
     * @param memberId 会员信息主键
     * @return 结果
     */
    @Override
    public int deleteShopMemberByMemberId(Long memberId)
    {
        return shopMemberMapper.deleteShopMemberByMemberId(memberId);
    }
}
