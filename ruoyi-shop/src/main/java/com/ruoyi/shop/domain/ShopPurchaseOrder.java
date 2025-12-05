package com.ruoyi.shop.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 采购订单对象 shop_purchase_order
 * 
 * @author lggyx
 * @date 2025-12-05
 */
public class ShopPurchaseOrder extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 订单ID */
    private Long orderId;

    /** 采购单号 */
    @Excel(name = "采购单号")
    private String orderNo;

    /** 供应商ID */
    @Excel(name = "供应商ID")
    private Long supplierId;

    /** 订单金额 */
    @Excel(name = "订单金额")
    private BigDecimal orderAmount;

    /** 已付金额 */
    @Excel(name = "已付金额")
    private BigDecimal paidAmount;

    /** 订单状态（0待审核 1已审核 2已入库 3已取消） */
    @Excel(name = "订单状态", readConverterExp = "0=待审核,1=已审核,2=已入库,3=已取消")
    private String status;

    /** 下单时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "下单时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date orderTime;

    /** 预期到货时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "预期到货时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date expectTime;

    /** 审核人 */
    @Excel(name = "审核人")
    private String auditBy;

    /** 审核时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "审核时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date auditTime;

    /** 入库人 */
    @Excel(name = "入库人")
    private String receiptBy;

    /** 入库时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "入库时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date receiptTime;

    /** 删除标志（0代表存在 2代表删除） */
    private String delFlag;

    public void setOrderId(Long orderId) 
    {
        this.orderId = orderId;
    }

    public Long getOrderId() 
    {
        return orderId;
    }

    public void setOrderNo(String orderNo) 
    {
        this.orderNo = orderNo;
    }

    public String getOrderNo() 
    {
        return orderNo;
    }

    public void setSupplierId(Long supplierId) 
    {
        this.supplierId = supplierId;
    }

    public Long getSupplierId() 
    {
        return supplierId;
    }

    public void setOrderAmount(BigDecimal orderAmount) 
    {
        this.orderAmount = orderAmount;
    }

    public BigDecimal getOrderAmount() 
    {
        return orderAmount;
    }

    public void setPaidAmount(BigDecimal paidAmount) 
    {
        this.paidAmount = paidAmount;
    }

    public BigDecimal getPaidAmount() 
    {
        return paidAmount;
    }

    public void setStatus(String status) 
    {
        this.status = status;
    }

    public String getStatus() 
    {
        return status;
    }

    public void setOrderTime(Date orderTime) 
    {
        this.orderTime = orderTime;
    }

    public Date getOrderTime() 
    {
        return orderTime;
    }

    public void setExpectTime(Date expectTime) 
    {
        this.expectTime = expectTime;
    }

    public Date getExpectTime() 
    {
        return expectTime;
    }

    public void setAuditBy(String auditBy) 
    {
        this.auditBy = auditBy;
    }

    public String getAuditBy() 
    {
        return auditBy;
    }

    public void setAuditTime(Date auditTime) 
    {
        this.auditTime = auditTime;
    }

    public Date getAuditTime() 
    {
        return auditTime;
    }

    public void setReceiptBy(String receiptBy) 
    {
        this.receiptBy = receiptBy;
    }

    public String getReceiptBy() 
    {
        return receiptBy;
    }

    public void setReceiptTime(Date receiptTime) 
    {
        this.receiptTime = receiptTime;
    }

    public Date getReceiptTime() 
    {
        return receiptTime;
    }

    public void setDelFlag(String delFlag) 
    {
        this.delFlag = delFlag;
    }

    public String getDelFlag() 
    {
        return delFlag;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("orderId", getOrderId())
            .append("orderNo", getOrderNo())
            .append("supplierId", getSupplierId())
            .append("orderAmount", getOrderAmount())
            .append("paidAmount", getPaidAmount())
            .append("status", getStatus())
            .append("orderTime", getOrderTime())
            .append("expectTime", getExpectTime())
            .append("auditBy", getAuditBy())
            .append("auditTime", getAuditTime())
            .append("receiptBy", getReceiptBy())
            .append("receiptTime", getReceiptTime())
            .append("delFlag", getDelFlag())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}
