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
import com.ruoyi.shop.domain.ShopPurchaseOrderDetail;
import com.ruoyi.shop.service.IShopPurchaseOrderDetailService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 采购订单明细Controller
 * 
 * @author lggyx
 * @date 2025-12-05
 */
@RestController
@RequestMapping("/shop/purchaseOrderDetail")
public class ShopPurchaseOrderDetailController extends BaseController
{
    @Autowired
    private IShopPurchaseOrderDetailService shopPurchaseOrderDetailService;

    /**
     * 查询采购订单明细列表
     */
    @PreAuthorize("@ss.hasPermi('shop:purchaseOrderDetail:list')")
    @GetMapping("/list")
    public TableDataInfo list(ShopPurchaseOrderDetail shopPurchaseOrderDetail)
    {
        startPage();
        List<ShopPurchaseOrderDetail> list = shopPurchaseOrderDetailService.selectShopPurchaseOrderDetailList(shopPurchaseOrderDetail);
        return getDataTable(list);
    }

    /**
     * 导出采购订单明细列表
     */
    @PreAuthorize("@ss.hasPermi('shop:purchaseOrderDetail:export')")
    @Log(title = "采购订单明细", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ShopPurchaseOrderDetail shopPurchaseOrderDetail)
    {
        List<ShopPurchaseOrderDetail> list = shopPurchaseOrderDetailService.selectShopPurchaseOrderDetailList(shopPurchaseOrderDetail);
        ExcelUtil<ShopPurchaseOrderDetail> util = new ExcelUtil<ShopPurchaseOrderDetail>(ShopPurchaseOrderDetail.class);
        util.exportExcel(response, list, "采购订单明细数据");
    }

    /**
     * 获取采购订单明细详细信息
     */
    @PreAuthorize("@ss.hasPermi('shop:purchaseOrderDetail:query')")
    @GetMapping(value = "/{detailId}")
    public AjaxResult getInfo(@PathVariable("detailId") Long detailId)
    {
        return success(shopPurchaseOrderDetailService.selectShopPurchaseOrderDetailByDetailId(detailId));
    }

    /**
     * 新增采购订单明细
     */
    @PreAuthorize("@ss.hasPermi('shop:purchaseOrderDetail:add')")
    @Log(title = "采购订单明细", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ShopPurchaseOrderDetail shopPurchaseOrderDetail)
    {
        return toAjax(shopPurchaseOrderDetailService.insertShopPurchaseOrderDetail(shopPurchaseOrderDetail));
    }

    /**
     * 修改采购订单明细
     */
    @PreAuthorize("@ss.hasPermi('shop:purchaseOrderDetail:edit')")
    @Log(title = "采购订单明细", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ShopPurchaseOrderDetail shopPurchaseOrderDetail)
    {
        return toAjax(shopPurchaseOrderDetailService.updateShopPurchaseOrderDetail(shopPurchaseOrderDetail));
    }

    /**
     * 删除采购订单明细
     */
    @PreAuthorize("@ss.hasPermi('shop:purchaseOrderDetail:remove')")
    @Log(title = "采购订单明细", businessType = BusinessType.DELETE)
	@DeleteMapping("/{detailIds}")
    public AjaxResult remove(@PathVariable Long[] detailIds)
    {
        return toAjax(shopPurchaseOrderDetailService.deleteShopPurchaseOrderDetailByDetailIds(detailIds));
    }
}
