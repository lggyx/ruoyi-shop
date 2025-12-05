package com.ruoyi.shop.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 库存流水对象 shop_stock_log
 * 
 * @author ruoyi
 * @date 2025-12-05
 */
public class ShopStockLog extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 流水ID */
    private Long logId;

    /** 商品ID */
    @Excel(name = "商品ID")
    private Long productId;

    /** 规格ID */
    @Excel(name = "规格ID")
    private Long specId;

    /** 变动类型（1入库 2出库 3销售 4退货 5调拨） */
    @Excel(name = "变动类型", readConverterExp = "1=入库,2=出库,3=销售,4=退货,5=调拨")
    private String changeType;

    /** 变动数量 */
    @Excel(name = "变动数量")
    private Long changeNum;

    /** 变动前库存 */
    @Excel(name = "变动前库存")
    private Long beforeStock;

    /** 变动后库存 */
    @Excel(name = "变动后库存")
    private Long afterStock;

    /** 关联订单号 */
    @Excel(name = "关联订单号")
    private String orderNo;

    public void setLogId(Long logId) 
    {
        this.logId = logId;
    }

    public Long getLogId() 
    {
        return logId;
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

    public void setChangeType(String changeType) 
    {
        this.changeType = changeType;
    }

    public String getChangeType() 
    {
        return changeType;
    }

    public void setChangeNum(Long changeNum) 
    {
        this.changeNum = changeNum;
    }

    public Long getChangeNum() 
    {
        return changeNum;
    }

    public void setBeforeStock(Long beforeStock) 
    {
        this.beforeStock = beforeStock;
    }

    public Long getBeforeStock() 
    {
        return beforeStock;
    }

    public void setAfterStock(Long afterStock) 
    {
        this.afterStock = afterStock;
    }

    public Long getAfterStock() 
    {
        return afterStock;
    }

    public void setOrderNo(String orderNo) 
    {
        this.orderNo = orderNo;
    }

    public String getOrderNo() 
    {
        return orderNo;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("logId", getLogId())
            .append("productId", getProductId())
            .append("specId", getSpecId())
            .append("changeType", getChangeType())
            .append("changeNum", getChangeNum())
            .append("beforeStock", getBeforeStock())
            .append("afterStock", getAfterStock())
            .append("orderNo", getOrderNo())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("remark", getRemark())
            .toString();
    }
}
