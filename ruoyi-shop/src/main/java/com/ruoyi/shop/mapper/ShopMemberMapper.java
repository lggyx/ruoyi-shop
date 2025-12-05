package com.ruoyi.shop.mapper;

import java.util.List;
import com.ruoyi.shop.domain.ShopMember;

/**
 * 会员信息Mapper接口
 * 
 * @author lggyx
 * @date 2025-12-05
 */
public interface ShopMemberMapper 
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
     * 删除会员信息
     * 
     * @param memberId 会员信息主键
     * @return 结果
     */
    public int deleteShopMemberByMemberId(Long memberId);

    /**
     * 批量删除会员信息
     * 
     * @param memberIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteShopMemberByMemberIds(Long[] memberIds);
}
