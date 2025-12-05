package com.ruoyi.shop.domain;

import java.math.BigDecimal;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 商品信息对象 shop_product
 * 
 * @author lggyx
 * @date 2025-12-05
 */
public class ShopProduct extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 商品ID */
    private Long productId;

    /** 分类ID */
    @Excel(name = "分类ID")
    private Long categoryId;

    /** 供应商ID */
    @Excel(name = "供应商ID")
    private Long supplierId;

    /** 商品名称 */
    @Excel(name = "商品名称")
    private String productName;

    /** 商品编码 */
    @Excel(name = "商品编码")
    private String productCode;

    /** 条形码 */
    @Excel(name = "条形码")
    private String barcode;

    /** 规格类型（0单规格 1多规格） */
    @Excel(name = "规格类型", readConverterExp = "0=单规格,1=多规格")
    private String specType;

    /** 进货价 */
    @Excel(name = "进货价")
    private BigDecimal priceIn;

    /** 销售价 */
    @Excel(name = "销售价")
    private BigDecimal priceSale;

    /** 会员价 */
    @Excel(name = "会员价")
    private BigDecimal priceVip;

    /** 单位（个/瓶/斤等） */
    @Excel(name = "单位", readConverterExp = "个=/瓶/斤等")
    private String unit;

    /** 品牌 */
    @Excel(name = "品牌")
    private String brand;

    /** 产地 */
    @Excel(name = "产地")
    private String origin;

    /** 保质期（天） */
    @Excel(name = "保质期", readConverterExp = "天=")
    private Long shelfLife;

    /** 库存预警值 */
    @Excel(name = "库存预警值")
    private Long warningStock;

    /** 主图地址 */
    @Excel(name = "主图地址")
    private String mainImage;

    /** 相册地址 */
    @Excel(name = "相册地址")
    private String album;

    /** 商品描述 */
    @Excel(name = "商品描述")
    private String description;

    /** 状态（0上架 1下架 2缺货） */
    @Excel(name = "状态", readConverterExp = "0=上架,1=下架,2=缺货")
    private String status;

    /** 删除标志（0代表存在 2代表删除） */
    private String delFlag;

    public void setProductId(Long productId) 
    {
        this.productId = productId;
    }

    public Long getProductId() 
    {
        return productId;
    }

    public void setCategoryId(Long categoryId) 
    {
        this.categoryId = categoryId;
    }

    public Long getCategoryId() 
    {
        return categoryId;
    }

    public void setSupplierId(Long supplierId) 
    {
        this.supplierId = supplierId;
    }

    public Long getSupplierId() 
    {
        return supplierId;
    }

    public void setProductName(String productName) 
    {
        this.productName = productName;
    }

    public String getProductName() 
    {
        return productName;
    }

    public void setProductCode(String productCode) 
    {
        this.productCode = productCode;
    }

    public String getProductCode() 
    {
        return productCode;
    }

    public void setBarcode(String barcode) 
    {
        this.barcode = barcode;
    }

    public String getBarcode() 
    {
        return barcode;
    }

    public void setSpecType(String specType) 
    {
        this.specType = specType;
    }

    public String getSpecType() 
    {
        return specType;
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

    public void setUnit(String unit) 
    {
        this.unit = unit;
    }

    public String getUnit() 
    {
        return unit;
    }

    public void setBrand(String brand) 
    {
        this.brand = brand;
    }

    public String getBrand() 
    {
        return brand;
    }

    public void setOrigin(String origin) 
    {
        this.origin = origin;
    }

    public String getOrigin() 
    {
        return origin;
    }

    public void setShelfLife(Long shelfLife) 
    {
        this.shelfLife = shelfLife;
    }

    public Long getShelfLife() 
    {
        return shelfLife;
    }

    public void setWarningStock(Long warningStock) 
    {
        this.warningStock = warningStock;
    }

    public Long getWarningStock() 
    {
        return warningStock;
    }

    public void setMainImage(String mainImage) 
    {
        this.mainImage = mainImage;
    }

    public String getMainImage() 
    {
        return mainImage;
    }

    public void setAlbum(String album) 
    {
        this.album = album;
    }

    public String getAlbum() 
    {
        return album;
    }

    public void setDescription(String description) 
    {
        this.description = description;
    }

    public String getDescription() 
    {
        return description;
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
            .append("productId", getProductId())
            .append("categoryId", getCategoryId())
            .append("supplierId", getSupplierId())
            .append("productName", getProductName())
            .append("productCode", getProductCode())
            .append("barcode", getBarcode())
            .append("specType", getSpecType())
            .append("priceIn", getPriceIn())
            .append("priceSale", getPriceSale())
            .append("priceVip", getPriceVip())
            .append("unit", getUnit())
            .append("brand", getBrand())
            .append("origin", getOrigin())
            .append("shelfLife", getShelfLife())
            .append("warningStock", getWarningStock())
            .append("mainImage", getMainImage())
            .append("album", getAlbum())
            .append("description", getDescription())
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
