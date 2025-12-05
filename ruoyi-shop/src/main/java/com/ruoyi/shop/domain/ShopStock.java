package com.ruoyi.shop.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 库存信息对象 shop_stock
 * 
 * @author lggyx
 * @date 2025-12-05
 */
public class ShopStock extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 库存ID */
    private Long stockId;

    /** 商品ID */
    @Excel(name = "商品ID")
    private Long productId;

    /** 规格ID */
    @Excel(name = "规格ID")
    private Long specId;

    /** 库存数量 */
    @Excel(name = "库存数量")
    private Long stockQuantity;

    /** 冻结数量 */
    @Excel(name = "冻结数量")
    private Long freezeQuantity;

    /** 累计入库 */
    @Excel(name = "累计入库")
    private Long totalIn;

    /** 累计出库 */
    @Excel(name = "累计出库")
    private Long totalOut;

    /** 库存预警值 */
    @Excel(name = "库存预警值")
    private Long warningStock;

    /** 最后入库时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "最后入库时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date lastInTime;

    /** 最后出库时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "最后出库时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date lastOutTime;

    public void setStockId(Long stockId) 
    {
        this.stockId = stockId;
    }

    public Long getStockId() 
    {
        return stockId;
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

    public void setStockQuantity(Long stockQuantity) 
    {
        this.stockQuantity = stockQuantity;
    }

    public Long getStockQuantity() 
    {
        return stockQuantity;
    }

    public void setFreezeQuantity(Long freezeQuantity) 
    {
        this.freezeQuantity = freezeQuantity;
    }

    public Long getFreezeQuantity() 
    {
        return freezeQuantity;
    }

    public void setTotalIn(Long totalIn) 
    {
        this.totalIn = totalIn;
    }

    public Long getTotalIn() 
    {
        return totalIn;
    }

    public void setTotalOut(Long totalOut) 
    {
        this.totalOut = totalOut;
    }

    public Long getTotalOut() 
    {
        return totalOut;
    }

    public void setWarningStock(Long warningStock) 
    {
        this.warningStock = warningStock;
    }

    public Long getWarningStock() 
    {
        return warningStock;
    }

    public void setLastInTime(Date lastInTime) 
    {
        this.lastInTime = lastInTime;
    }

    public Date getLastInTime() 
    {
        return lastInTime;
    }

    public void setLastOutTime(Date lastOutTime) 
    {
        this.lastOutTime = lastOutTime;
    }

    public Date getLastOutTime() 
    {
        return lastOutTime;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("stockId", getStockId())
            .append("productId", getProductId())
            .append("specId", getSpecId())
            .append("stockQuantity", getStockQuantity())
            .append("freezeQuantity", getFreezeQuantity())
            .append("totalIn", getTotalIn())
            .append("totalOut", getTotalOut())
            .append("warningStock", getWarningStock())
            .append("lastInTime", getLastInTime())
            .append("lastOutTime", getLastOutTime())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}
