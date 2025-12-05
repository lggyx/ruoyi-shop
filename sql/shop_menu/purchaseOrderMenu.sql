-- 菜单 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('采购订单', '2000', '1', 'purchaseOrder', 'shop/purchaseOrder/index', 1, 0, 'C', '0', '0', 'shop:purchaseOrder:list', '#', 'admin', sysdate(), '', null, '采购订单菜单');

-- 按钮父菜单ID
SELECT @parentId := LAST_INSERT_ID();

-- 按钮 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('采购订单查询', @parentId, '1',  '#', '', 1, 0, 'F', '0', '0', 'shop:purchaseOrder:query',        '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('采购订单新增', @parentId, '2',  '#', '', 1, 0, 'F', '0', '0', 'shop:purchaseOrder:add',          '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('采购订单修改', @parentId, '3',  '#', '', 1, 0, 'F', '0', '0', 'shop:purchaseOrder:edit',         '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('采购订单删除', @parentId, '4',  '#', '', 1, 0, 'F', '0', '0', 'shop:purchaseOrder:remove',       '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('采购订单导出', @parentId, '5',  '#', '', 1, 0, 'F', '0', '0', 'shop:purchaseOrder:export',       '#', 'admin', sysdate(), '', null, '');