package com.ruoyi.web.controller.shop;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.shop.domain.ShopSaleOrderDetail;
import com.ruoyi.shop.service.IShopSaleOrderDetailService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 销售订单明细Controller
 * 
 * @author lggyx
 * @date 2025-12-05
 */
@RestController
@RequestMapping("/shop/saleOrderDetail")
public class ShopSaleOrderDetailController extends BaseController
{
    @Autowired
    private IShopSaleOrderDetailService shopSaleOrderDetailService;

    /**
     * 查询销售订单明细列表
     */
    @PreAuthorize("@ss.hasPermi('shop:saleOrderDetail:list')")
    @GetMapping("/list")
    public TableDataInfo list(ShopSaleOrderDetail shopSaleOrderDetail)
    {
        startPage();
        List<ShopSaleOrderDetail> list = shopSaleOrderDetailService.selectShopSaleOrderDetailList(shopSaleOrderDetail);
        return getDataTable(list);
    }

    /**
     * 导出销售订单明细列表
     */
    @PreAuthorize("@ss.hasPermi('shop:saleOrderDetail:export')")
    @Log(title = "销售订单明细", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ShopSaleOrderDetail shopSaleOrderDetail)
    {
        List<ShopSaleOrderDetail> list = shopSaleOrderDetailService.selectShopSaleOrderDetailList(shopSaleOrderDetail);
        ExcelUtil<ShopSaleOrderDetail> util = new ExcelUtil<ShopSaleOrderDetail>(ShopSaleOrderDetail.class);
        util.exportExcel(response, list, "销售订单明细数据");
    }

    /**
     * 获取销售订单明细详细信息
     */
    @PreAuthorize("@ss.hasPermi('shop:saleOrderDetail:query')")
    @GetMapping(value = "/{detailId}")
    public AjaxResult getInfo(@PathVariable("detailId") Long detailId)
    {
        return success(shopSaleOrderDetailService.selectShopSaleOrderDetailByDetailId(detailId));
    }

    /**
     * 新增销售订单明细
     */
    @PreAuthorize("@ss.hasPermi('shop:saleOrderDetail:add')")
    @Log(title = "销售订单明细", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ShopSaleOrderDetail shopSaleOrderDetail)
    {
        return toAjax(shopSaleOrderDetailService.insertShopSaleOrderDetail(shopSaleOrderDetail));
    }

    /**
     * 修改销售订单明细
     */
    @PreAuthorize("@ss.hasPermi('shop:saleOrderDetail:edit')")
    @Log(title = "销售订单明细", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ShopSaleOrderDetail shopSaleOrderDetail)
    {
        return toAjax(shopSaleOrderDetailService.updateShopSaleOrderDetail(shopSaleOrderDetail));
    }

    /**
     * 删除销售订单明细
     */
    @PreAuthorize("@ss.hasPermi('shop:saleOrderDetail:remove')")
    @Log(title = "销售订单明细", businessType = BusinessType.DELETE)
	@DeleteMapping("/{detailIds}")
    public AjaxResult remove(@PathVariable Long[] detailIds)
    {
        return toAjax(shopSaleOrderDetailService.deleteShopSaleOrderDetailByDetailIds(detailIds));
    }
}
