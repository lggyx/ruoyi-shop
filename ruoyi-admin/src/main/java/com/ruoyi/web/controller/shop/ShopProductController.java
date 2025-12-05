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
import com.ruoyi.shop.domain.ShopProduct;
import com.ruoyi.shop.service.IShopProductService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 商品信息Controller
 * 
 * @author lggyx
 * @date 2025-12-05
 */
@RestController
@RequestMapping("/shop/product")
public class ShopProductController extends BaseController
{
    @Autowired
    private IShopProductService shopProductService;

    /**
     * 查询商品信息列表
     */
    @PreAuthorize("@ss.hasPermi('shop:product:list')")
    @GetMapping("/list")
    public TableDataInfo list(ShopProduct shopProduct)
    {
        startPage();
        List<ShopProduct> list = shopProductService.selectShopProductList(shopProduct);
        return getDataTable(list);
    }

    /**
     * 导出商品信息列表
     */
    @PreAuthorize("@ss.hasPermi('shop:product:export')")
    @Log(title = "商品信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ShopProduct shopProduct)
    {
        List<ShopProduct> list = shopProductService.selectShopProductList(shopProduct);
        ExcelUtil<ShopProduct> util = new ExcelUtil<ShopProduct>(ShopProduct.class);
        util.exportExcel(response, list, "商品信息数据");
    }

    /**
     * 获取商品信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('shop:product:query')")
    @GetMapping(value = "/{productId}")
    public AjaxResult getInfo(@PathVariable("productId") Long productId)
    {
        return success(shopProductService.selectShopProductByProductId(productId));
    }

    /**
     * 新增商品信息
     */
    @PreAuthorize("@ss.hasPermi('shop:product:add')")
    @Log(title = "商品信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ShopProduct shopProduct)
    {
        return toAjax(shopProductService.insertShopProduct(shopProduct));
    }

    /**
     * 修改商品信息
     */
    @PreAuthorize("@ss.hasPermi('shop:product:edit')")
    @Log(title = "商品信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ShopProduct shopProduct)
    {
        return toAjax(shopProductService.updateShopProduct(shopProduct));
    }

    /**
     * 删除商品信息
     */
    @PreAuthorize("@ss.hasPermi('shop:product:remove')")
    @Log(title = "商品信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{productIds}")
    public AjaxResult remove(@PathVariable Long[] productIds)
    {
        return toAjax(shopProductService.deleteShopProductByProductIds(productIds));
    }
}
