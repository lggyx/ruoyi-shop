package com.ruoyi.shop.domain;

import java.math.BigDecimal;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 采购订单明细对象 shop_purchase_order_detail
 * 
 * @author lggyx
 * @date 2025-12-05
 */
public class ShopPurchaseOrderDetail extends BaseEntity
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

    /** 采购单价 */
    @Excel(name = "采购单价")
    private BigDecimal buyPrice;

    /** 采购数量 */
    @Excel(name = "采购数量")
    private Long buyNum;

    /** 小计金额 */
    @Excel(name = "小计金额")
    private BigDecimal totalAmount;

    /** 已入库数量 */
    @Excel(name = "已入库数量")
    private Long receiptNum;

    /** 状态（0待入库 1部分入库 2已入库） */
    @Excel(name = "状态", readConverterExp = "0=待入库,1=部分入库,2=已入库")
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

    public void setBuyPrice(BigDecimal buyPrice) 
    {
        this.buyPrice = buyPrice;
    }

    public BigDecimal getBuyPrice() 
    {
        return buyPrice;
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

    public void setReceiptNum(Long receiptNum) 
    {
        this.receiptNum = receiptNum;
    }

    public Long getReceiptNum() 
    {
        return receiptNum;
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
            .append("buyPrice", getBuyPrice())
            .append("buyNum", getBuyNum())
            .append("totalAmount", getTotalAmount())
            .append("receiptNum", getReceiptNum())
            .append("status", getStatus())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}
