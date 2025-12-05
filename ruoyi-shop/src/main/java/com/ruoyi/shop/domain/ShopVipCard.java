package com.ruoyi.shop.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 会员卡信息对象 shop_vip_card
 * 
 * @author lggyx
 * @date 2025-12-05
 */
public class ShopVipCard extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 卡ID */
    private Long cardId;

    /** 会员ID */
    @Excel(name = "会员ID")
    private Long memberId;

    /** 卡号 */
    @Excel(name = "卡号")
    private String cardNo;

    /** 卡类型（0储值卡 1次卡） */
    @Excel(name = "卡类型", readConverterExp = "0=储值卡,1=次卡")
    private String cardType;

    /** 余额 */
    @Excel(name = "余额")
    private BigDecimal balance;

    /** 初始金额 */
    @Excel(name = "初始金额")
    private BigDecimal totalAmount;

    /** 过期日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "过期日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date expireDate;

    /** 状态（0正常 1已过期 2已注销） */
    @Excel(name = "状态", readConverterExp = "0=正常,1=已过期,2=已注销")
    private String status;

    public void setCardId(Long cardId) 
    {
        this.cardId = cardId;
    }

    public Long getCardId() 
    {
        return cardId;
    }

    public void setMemberId(Long memberId) 
    {
        this.memberId = memberId;
    }

    public Long getMemberId() 
    {
        return memberId;
    }

    public void setCardNo(String cardNo) 
    {
        this.cardNo = cardNo;
    }

    public String getCardNo() 
    {
        return cardNo;
    }

    public void setCardType(String cardType) 
    {
        this.cardType = cardType;
    }

    public String getCardType() 
    {
        return cardType;
    }

    public void setBalance(BigDecimal balance) 
    {
        this.balance = balance;
    }

    public BigDecimal getBalance() 
    {
        return balance;
    }

    public void setTotalAmount(BigDecimal totalAmount) 
    {
        this.totalAmount = totalAmount;
    }

    public BigDecimal getTotalAmount() 
    {
        return totalAmount;
    }

    public void setExpireDate(Date expireDate) 
    {
        this.expireDate = expireDate;
    }

    public Date getExpireDate() 
    {
        return expireDate;
    }

    public void setStatus(String status) 
    {
        this.status = status;
    }

    public String getStatus() 
    {
        return status;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("cardId", getCardId())
            .append("memberId", getMemberId())
            .append("cardNo", getCardNo())
            .append("cardType", getCardType())
            .append("balance", getBalance())
            .append("totalAmount", getTotalAmount())
            .append("expireDate", getExpireDate())
            .append("status", getStatus())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}
