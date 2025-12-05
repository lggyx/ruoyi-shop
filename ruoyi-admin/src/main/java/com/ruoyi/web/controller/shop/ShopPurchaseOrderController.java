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
import com.ruoyi.shop.domain.ShopPurchaseOrder;
import com.ruoyi.shop.service.IShopPurchaseOrderService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 采购订单Controller
 * 
 * @author lggyx
 * @date 2025-12-05
 */
@RestController
@RequestMapping("/shop/purchaseOrder")
public class ShopPurchaseOrderController extends BaseController
{
    @Autowired
    private IShopPurchaseOrderService shopPurchaseOrderService;

    /**
     * 查询采购订单列表
     */
    @PreAuthorize("@ss.hasPermi('shop:purchaseOrder:list')")
    @GetMapping("/list")
    public TableDataInfo list(ShopPurchaseOrder shopPurchaseOrder)
    {
        startPage();
        List<ShopPurchaseOrder> list = shopPurchaseOrderService.selectShopPurchaseOrderList(shopPurchaseOrder);
        return getDataTable(list);
    }

    /**
     * 导出采购订单列表
     */
    @PreAuthorize("@ss.hasPermi('shop:purchaseOrder:export')")
    @Log(title = "采购订单", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ShopPurchaseOrder shopPurchaseOrder)
    {
        List<ShopPurchaseOrder> list = shopPurchaseOrderService.selectShopPurchaseOrderList(shopPurchaseOrder);
        ExcelUtil<ShopPurchaseOrder> util = new ExcelUtil<ShopPurchaseOrder>(ShopPurchaseOrder.class);
        util.exportExcel(response, list, "采购订单数据");
    }

    /**
     * 获取采购订单详细信息
     */
    @PreAuthorize("@ss.hasPermi('shop:purchaseOrder:query')")
    @GetMapping(value = "/{orderId}")
    public AjaxResult getInfo(@PathVariable("orderId") Long orderId)
    {
        return success(shopPurchaseOrderService.selectShopPurchaseOrderByOrderId(orderId));
    }

    /**
     * 新增采购订单
     */
    @PreAuthorize("@ss.hasPermi('shop:purchaseOrder:add')")
    @Log(title = "采购订单", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ShopPurchaseOrder shopPurchaseOrder)
    {
        return toAjax(shopPurchaseOrderService.insertShopPurchaseOrder(shopPurchaseOrder));
    }

    /**
     * 修改采购订单
     */
    @PreAuthorize("@ss.hasPermi('shop:purchaseOrder:edit')")
    @Log(title = "采购订单", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ShopPurchaseOrder shopPurchaseOrder)
    {
        return toAjax(shopPurchaseOrderService.updateShopPurchaseOrder(shopPurchaseOrder));
    }

    /**
     * 删除采购订单
     */
    @PreAuthorize("@ss.hasPermi('shop:purchaseOrder:remove')")
    @Log(title = "采购订单", businessType = BusinessType.DELETE)
	@DeleteMapping("/{orderIds}")
    public AjaxResult remove(@PathVariable Long[] orderIds)
    {
        return toAjax(shopPurchaseOrderService.deleteShopPurchaseOrderByOrderIds(orderIds));
    }
}
