package com.ruoyi.shop.domain;

import java.math.BigDecimal;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 销售订单明细对象 shop_sale_order_detail
 * 
 * @author lggyx
 * @date 2025-12-05
 */
public class ShopSaleOrderDetail extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 明细ID */
    private Long detailId;

    /** 订单ID */
    @Excel(name = "订单ID")
    private Long orderId;

    /** 商品ID */
    @Excel(name = "商品ID")
    private Long productId;

    /** 规格ID */
    @Excel(name = "规格ID")
    private Long specId;

    /** 销售单价 */
    @Excel(name = "销售单价")
    private BigDecimal salePrice;

    /** 会员单价 */
    @Excel(name = "会员单价")
    private BigDecimal vipPrice;

    /** 购买数量 */
    @Excel(name = "购买数量")
    private Long buyNum;

    /** 小计金额 */
    @Excel(name = "小计金额")
    private BigDecimal totalAmount;

    /** 优惠金额 */
    @Excel(name = "优惠金额")
    private BigDecimal discount;

    /** 状态（0正常 1退货） */
    @Excel(name = "状态", readConverterExp = "0=正常,1=退货")
    private String status;

    public void setDetailId(Long detailId) 
    {
        this.detailId = detailId;
    }

    public Long getDetailId() 
    {
        return detailId;
    }

    public void setOrderId(Long orderId) 
    {
        this.orderId = orderId;
    }

    public Long getOrderId() 
    {
        return orderId;
    }

    public void setProductId(Long productId) 
    {
        this.productId = productId;
    }

    public Long getProductId() 
    {
        return productId;
    }

    public void setSpecId(Long specId) 
    {
        this.specId = specId;
    }

    public Long getSpecId() 
    {
        return specId;
    }

    public void setSalePrice(BigDecimal salePrice) 
    {
        this.salePrice = salePrice;
    }

    public BigDecimal getSalePrice() 
    {
        return salePrice;
    }

    public void setVipPrice(BigDecimal vipPrice) 
    {
        this.vipPrice = vipPrice;
    }

    public BigDecimal getVipPrice() 
    {
        return vipPrice;
    }

    public void setBuyNum(Long buyNum) 
    {
        this.buyNum = buyNum;
    }

    public Long getBuyNum() 
    {
        return buyNum;
    }

    public void setTotalAmount(BigDecimal totalAmount) 
    {
        this.totalAmount = totalAmount;
    }

    public BigDecimal getTotalAmount() 
    {
        return totalAmount;
    }

    public void setDiscount(BigDecimal discount) 
    {
        this.discount = discount;
    }

    public BigDecimal getDiscount() 
    {
        return discount;
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
            .append("detailId", getDetailId())
            .append("orderId", getOrderId())
            .append("productId", getProductId())
            .append("specId", getSpecId())
            .append("salePrice", getSalePrice())
            .append("vipPrice", getVipPrice())
            .append("buyNum", getBuyNum())
            .append("totalAmount", getTotalAmount())
            .append("discount", getDiscount())
            .append("status", getStatus())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}
