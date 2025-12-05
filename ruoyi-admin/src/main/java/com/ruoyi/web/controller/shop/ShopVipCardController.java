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
import com.ruoyi.shop.domain.ShopVipCard;
import com.ruoyi.shop.service.IShopVipCardService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 会员卡信息Controller
 * 
 * @author lggyx
 * @date 2025-12-05
 */
@RestController
@RequestMapping("/shop/vipCard")
public class ShopVipCardController extends BaseController
{
    @Autowired
    private IShopVipCardService shopVipCardService;

    /**
     * 查询会员卡信息列表
     */
    @PreAuthorize("@ss.hasPermi('shop:vipCard:list')")
    @GetMapping("/list")
    public TableDataInfo list(ShopVipCard shopVipCard)
    {
        startPage();
        List<ShopVipCard> list = shopVipCardService.selectShopVipCardList(shopVipCard);
        return getDataTable(list);
    }

    /**
     * 导出会员卡信息列表
     */
    @PreAuthorize("@ss.hasPermi('shop:vipCard:export')")
    @Log(title = "会员卡信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ShopVipCard shopVipCard)
    {
        List<ShopVipCard> list = shopVipCardService.selectShopVipCardList(shopVipCard);
        ExcelUtil<ShopVipCard> util = new ExcelUtil<ShopVipCard>(ShopVipCard.class);
        util.exportExcel(response, list, "会员卡信息数据");
    }

    /**
     * 获取会员卡信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('shop:vipCard:query')")
    @GetMapping(value = "/{cardId}")
    public AjaxResult getInfo(@PathVariable("cardId") Long cardId)
    {
        return success(shopVipCardService.selectShopVipCardByCardId(cardId));
    }

    /**
     * 新增会员卡信息
     */
    @PreAuthorize("@ss.hasPermi('shop:vipCard:add')")
    @Log(title = "会员卡信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ShopVipCard shopVipCard)
    {
        return toAjax(shopVipCardService.insertShopVipCard(shopVipCard));
    }

    /**
     * 修改会员卡信息
     */
    @PreAuthorize("@ss.hasPermi('shop:vipCard:edit')")
    @Log(title = "会员卡信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ShopVipCard shopVipCard)
    {
        return toAjax(shopVipCardService.updateShopVipCard(shopVipCard));
    }

    /**
     * 删除会员卡信息
     */
    @PreAuthorize("@ss.hasPermi('shop:vipCard:remove')")
    @Log(title = "会员卡信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{cardIds}")
    public AjaxResult remove(@PathVariable Long[] cardIds)
    {
        return toAjax(shopVipCardService.deleteShopVipCardByCardIds(cardIds));
    }
}
