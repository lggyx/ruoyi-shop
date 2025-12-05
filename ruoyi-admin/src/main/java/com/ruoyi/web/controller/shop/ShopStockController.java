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
import com.ruoyi.shop.domain.ShopStock;
import com.ruoyi.shop.service.IShopStockService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 库存信息Controller
 * 
 * @author lggyx
 * @date 2025-12-05
 */
@RestController
@RequestMapping("/shop/stock")
public class ShopStockController extends BaseController
{
    @Autowired
    private IShopStockService shopStockService;

    /**
     * 查询库存信息列表
     */
    @PreAuthorize("@ss.hasPermi('shop:stock:list')")
    @GetMapping("/list")
    public TableDataInfo list(ShopStock shopStock)
    {
        startPage();
        List<ShopStock> list = shopStockService.selectShopStockList(shopStock);
        return getDataTable(list);
    }

    /**
     * 导出库存信息列表
     */
    @PreAuthorize("@ss.hasPermi('shop:stock:export')")
    @Log(title = "库存信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ShopStock shopStock)
    {
        List<ShopStock> list = shopStockService.selectShopStockList(shopStock);
        ExcelUtil<ShopStock> util = new ExcelUtil<ShopStock>(ShopStock.class);
        util.exportExcel(response, list, "库存信息数据");
    }

    /**
     * 获取库存信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('shop:stock:query')")
    @GetMapping(value = "/{stockId}")
    public AjaxResult getInfo(@PathVariable("stockId") Long stockId)
    {
        return success(shopStockService.selectShopStockByStockId(stockId));
    }

    /**
     * 新增库存信息
     */
    @PreAuthorize("@ss.hasPermi('shop:stock:add')")
    @Log(title = "库存信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ShopStock shopStock)
    {
        return toAjax(shopStockService.insertShopStock(shopStock));
    }

    /**
     * 修改库存信息
     */
    @PreAuthorize("@ss.hasPermi('shop:stock:edit')")
    @Log(title = "库存信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ShopStock shopStock)
    {
        return toAjax(shopStockService.updateShopStock(shopStock));
    }

    /**
     * 删除库存信息
     */
    @PreAuthorize("@ss.hasPermi('shop:stock:remove')")
    @Log(title = "库存信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{stockIds}")
    public AjaxResult remove(@PathVariable Long[] stockIds)
    {
        return toAjax(shopStockService.deleteShopStockByStockIds(stockIds));
    }
}
