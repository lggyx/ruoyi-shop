package com.ruoyi.shop.domain;

import java.math.BigDecimal;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 商品规格对象 shop_product_spec
 * 
 * @author lggyx
 * @date 2025-12-05
 */
public class ShopProductSpec extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 规格ID */
    private Long specId;

    /** 商品ID */
    @Excel(name = "商品ID")
    private Long productId;

    /** 规格名称（如：红色/大号） */
    @Excel(name = "规格名称", readConverterExp = "如=：红色/大号")
    private String specName;

    /** 规格编码 */
    @Excel(name = "规格编码")
    private String specCode;

    /** 进货价 */
    @Excel(name = "进货价")
    private BigDecimal priceIn;

    /** 销售价 */
    @Excel(name = "销售价")
    private BigDecimal priceSale;

    /** 会员价 */
    @Excel(name = "会员价")
    private BigDecimal priceVip;

    /** 库存数量 */
    @Excel(name = "库存数量")
    private Long stock;

    /** 库存预警值 */
    @Excel(name = "库存预警值")
    private Long warningStock;

    /** 规格条码 */
    @Excel(name = "规格条码")
    private String barcode;

    /** 状态（0正常 1停用） */
    @Excel(name = "状态", readConverterExp = "0=正常,1=停用")
    private String status;

    /** 删除标志（0代表存在 2代表删除） */
    private String delFlag;

    public void setSpecId(Long specId) 
    {
        this.specId = specId;
    }

    public Long getSpecId() 
    {
        return specId;
    }

    public void setProductId(Long productId) 
    {
        this.productId = productId;
    }

    public Long getProductId() 
    {
        return productId;
    }

    public void setSpecName(String specName) 
    {
        this.specName = specName;
    }

    public String getSpecName() 
    {
        return specName;
    }

    public void setSpecCode(String specCode) 
    {
        this.specCode = specCode;
    }

    public String getSpecCode() 
    {
        return specCode;
    }

    public void setPriceIn(BigDecimal priceIn) 
    {
        this.priceIn = priceIn;
    }

    public BigDecimal getPriceIn() 
    {
        return priceIn;
    }

    public void setPriceSale(BigDecimal priceSale) 
    {
        this.priceSale = priceSale;
    }

    public BigDecimal getPriceSale() 
    {
        return priceSale;
    }

    public void setPriceVip(BigDecimal priceVip) 
    {
        this.priceVip = priceVip;
    }

    public BigDecimal getPriceVip() 
    {
        return priceVip;
    }

    public void setStock(Long stock) 
    {
        this.stock = stock;
    }

    public Long getStock() 
    {
        return stock;
    }

    public void setWarningStock(Long warningStock) 
    {
        this.warningStock = warningStock;
    }

    public Long getWarningStock() 
    {
        return warningStock;
    }

    public void setBarcode(String barcode) 
    {
        this.barcode = barcode;
    }

    public String getBarcode() 
    {
        return barcode;
    }

    public void setStatus(String status) 
    {
        this.status = status;
    }

    public String getStatus() 
    {
        return status;
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
            .append("specId", getSpecId())
            .append("productId", getProductId())
            .append("specName", getSpecName())
            .append("specCode", getSpecCode())
            .append("priceIn", getPriceIn())
            .append("priceSale", getPriceSale())
            .append("priceVip", getPriceVip())
            .append("stock", getStock())
            .append("warningStock", getWarningStock())
            .append("barcode", getBarcode())
            .append("status", getStatus())
            .append("delFlag", getDelFlag())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}
