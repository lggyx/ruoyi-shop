package com.ruoyi.shop.service;

import java.util.List;
import com.ruoyi.shop.domain.ShopMember;

/**
 * 会员信息Service接口
 * 
 * @author lggyx
 * @date 2025-12-05
 */
public interface IShopMemberService 
{
    /**
     * 查询会员信息
     * 
     * @param memberId 会员信息主键
     * @return 会员信息
     */
    public ShopMember selectShopMemberByMemberId(Long memberId);

    /**
     * 查询会员信息列表
     * 
     * @param shopMember 会员信息
     * @return 会员信息集合
     */
    public List<ShopMember> selectShopMemberList(ShopMember shopMember);

    /**
     * 新增会员信息
     * 
     * @param shopMember 会员信息
     * @return 结果
     */
    public int insertShopMember(ShopMember shopMember);

    /**
     * 修改会员信息
     * 
     * @param shopMember 会员信息
     * @return 结果
     */
    public int updateShopMember(ShopMember shopMember);

    /**
     * 批量删除会员信息
     * 
     * @param memberIds 需要删除的会员信息主键集合
     * @return 结果
     */
    public int deleteShopMemberByMemberIds(Long[] memberIds);

    /**
     * 删除会员信息信息
     * 
     * @param memberId 会员信息主键
     * @return 结果
     */
    public int deleteShopMemberByMemberId(Long memberId);
}
