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
import com.ruoyi.shop.domain.ShopMember;
import com.ruoyi.shop.service.IShopMemberService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 会员信息Controller
 * 
 * @author lggyx
 * @date 2025-12-05
 */
@RestController
@RequestMapping("/shop/member")
public class ShopMemberController extends BaseController
{
    @Autowired
    private IShopMemberService shopMemberService;

    /**
     * 查询会员信息列表
     */
    @PreAuthorize("@ss.hasPermi('shop:member:list')")
    @GetMapping("/list")
    public TableDataInfo list(ShopMember shopMember)
    {
        startPage();
        List<ShopMember> list = shopMemberService.selectShopMemberList(shopMember);
        return getDataTable(list);
    }

    /**
     * 导出会员信息列表
     */
    @PreAuthorize("@ss.hasPermi('shop:member:export')")
    @Log(title = "会员信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ShopMember shopMember)
    {
        List<ShopMember> list = shopMemberService.selectShopMemberList(shopMember);
        ExcelUtil<ShopMember> util = new ExcelUtil<ShopMember>(ShopMember.class);
        util.exportExcel(response, list, "会员信息数据");
    }

    /**
     * 获取会员信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('shop:member:query')")
    @GetMapping(value = "/{memberId}")
    public AjaxResult getInfo(@PathVariable("memberId") Long memberId)
    {
        return success(shopMemberService.selectShopMemberByMemberId(memberId));
    }

    /**
     * 新增会员信息
     */
    @PreAuthorize("@ss.hasPermi('shop:member:add')")
    @Log(title = "会员信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ShopMember shopMember)
    {
        return toAjax(shopMemberService.insertShopMember(shopMember));
    }

    /**
     * 修改会员信息
     */
    @PreAuthorize("@ss.hasPermi('shop:member:edit')")
    @Log(title = "会员信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ShopMember shopMember)
    {
        return toAjax(shopMemberService.updateShopMember(shopMember));
    }

    /**
     * 删除会员信息
     */
    @PreAuthorize("@ss.hasPermi('shop:member:remove')")
    @Log(title = "会员信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{memberIds}")
    public AjaxResult remove(@PathVariable Long[] memberIds)
    {
        return toAjax(shopMemberService.deleteShopMemberByMemberIds(memberIds));
    }
}
