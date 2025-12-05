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
import com.ruoyi.shop.domain.ShopStockLog;
import com.ruoyi.shop.service.IShopStockLogService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 库存流水Controller
 * 
 * @author ruoyi
 * @date 2025-12-05
 */
@RestController
@RequestMapping("/shop/stockLog")
public class ShopStockLogController extends BaseController
{
    @Autowired
    private IShopStockLogService shopStockLogService;

    /**
     * 查询库存流水列表
     */
    @PreAuthorize("@ss.hasPermi('shop:stockLog:list')")
    @GetMapping("/list")
    public TableDataInfo list(ShopStockLog shopStockLog)
    {
        startPage();
        List<ShopStockLog> list = shopStockLogService.selectShopStockLogList(shopStockLog);
        return getDataTable(list);
    }

    /**
     * 导出库存流水列表
     */
    @PreAuthorize("@ss.hasPermi('shop:stockLog:export')")
    @Log(title = "库存流水", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ShopStockLog shopStockLog)
    {
        List<ShopStockLog> list = shopStockLogService.selectShopStockLogList(shopStockLog);
        ExcelUtil<ShopStockLog> util = new ExcelUtil<ShopStockLog>(ShopStockLog.class);
        util.exportExcel(response, list, "库存流水数据");
    }

    /**
     * 获取库存流水详细信息
     */
    @PreAuthorize("@ss.hasPermi('shop:stockLog:query')")
    @GetMapping(value = "/{logId}")
    public AjaxResult getInfo(@PathVariable("logId") Long logId)
    {
        return success(shopStockLogService.selectShopStockLogByLogId(logId));
    }

    /**
     * 新增库存流水
     */
    @PreAuthorize("@ss.hasPermi('shop:stockLog:add')")
    @Log(title = "库存流水", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ShopStockLog shopStockLog)
    {
        return toAjax(shopStockLogService.insertShopStockLog(shopStockLog));
    }

    /**
     * 修改库存流水
     */
    @PreAuthorize("@ss.hasPermi('shop:stockLog:edit')")
    @Log(title = "库存流水", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ShopStockLog shopStockLog)
    {
        return toAjax(shopStockLogService.updateShopStockLog(shopStockLog));
    }

    /**
     * 删除库存流水
     */
    @PreAuthorize("@ss.hasPermi('shop:stockLog:remove')")
    @Log(title = "库存流水", businessType = BusinessType.DELETE)
	@DeleteMapping("/{logIds}")
    public AjaxResult remove(@PathVariable Long[] logIds)
    {
        return toAjax(shopStockLogService.deleteShopStockLogByLogIds(logIds));
    }
}
