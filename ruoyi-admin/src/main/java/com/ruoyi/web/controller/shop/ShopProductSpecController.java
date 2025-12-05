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
import com.ruoyi.shop.domain.ShopProductSpec;
import com.ruoyi.shop.service.IShopProductSpecService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 商品规格Controller
 * 
 * @author lggyx
 * @date 2025-12-05
 */
@RestController
@RequestMapping("/shop/productSpec")
public class ShopProductSpecController extends BaseController
{
    @Autowired
    private IShopProductSpecService shopProductSpecService;

    /**
     * 查询商品规格列表
     */
    @PreAuthorize("@ss.hasPermi('shop:productSpec:list')")
    @GetMapping("/list")
    public TableDataInfo list(ShopProductSpec shopProductSpec)
    {
        startPage();
        List<ShopProductSpec> list = shopProductSpecService.selectShopProductSpecList(shopProductSpec);
        return getDataTable(list);
    }

    /**
     * 导出商品规格列表
     */
    @PreAuthorize("@ss.hasPermi('shop:productSpec:export')")
    @Log(title = "商品规格", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ShopProductSpec shopProductSpec)
    {
        List<ShopProductSpec> list = shopProductSpecService.selectShopProductSpecList(shopProductSpec);
        ExcelUtil<ShopProductSpec> util = new ExcelUtil<ShopProductSpec>(ShopProductSpec.class);
        util.exportExcel(response, list, "商品规格数据");
    }

    /**
     * 获取商品规格详细信息
     */
    @PreAuthorize("@ss.hasPermi('shop:productSpec:query')")
    @GetMapping(value = "/{specId}")
    public AjaxResult getInfo(@PathVariable("specId") Long specId)
    {
        return success(shopProductSpecService.selectShopProductSpecBySpecId(specId));
    }

    /**
     * 新增商品规格
     */
    @PreAuthorize("@ss.hasPermi('shop:productSpec:add')")
    @Log(title = "商品规格", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ShopProductSpec shopProductSpec)
    {
        return toAjax(shopProductSpecService.insertShopProductSpec(shopProductSpec));
    }

    /**
     * 修改商品规格
     */
    @PreAuthorize("@ss.hasPermi('shop:productSpec:edit')")
    @Log(title = "商品规格", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ShopProductSpec shopProductSpec)
    {
        return toAjax(shopProductSpecService.updateShopProductSpec(shopProductSpec));
    }

    /**
     * 删除商品规格
     */
    @PreAuthorize("@ss.hasPermi('shop:productSpec:remove')")
    @Log(title = "商品规格", businessType = BusinessType.DELETE)
	@DeleteMapping("/{specIds}")
    public AjaxResult remove(@PathVariable Long[] specIds)
    {
        return toAjax(shopProductSpecService.deleteShopProductSpecBySpecIds(specIds));
    }
}
