-- 菜单 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('商品规格', '2000', '1', 'productSpec', 'shop/productSpec/index', 1, 0, 'C', '0', '0', 'shop:productSpec:list', '#', 'admin', sysdate(), '', null, '商品规格菜单');

-- 按钮父菜单ID
SELECT @parentId := LAST_INSERT_ID();

-- 按钮 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('商品规格查询', @parentId, '1',  '#', '', 1, 0, 'F', '0', '0', 'shop:productSpec:query',        '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('商品规格新增', @parentId, '2',  '#', '', 1, 0, 'F', '0', '0', 'shop:productSpec:add',          '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('商品规格修改', @parentId, '3',  '#', '', 1, 0, 'F', '0', '0', 'shop:productSpec:edit',         '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('商品规格删除', @parentId, '4',  '#', '', 1, 0, 'F', '0', '0', 'shop:productSpec:remove',       '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('商品规格导出', @parentId, '5',  '#', '', 1, 0, 'F', '0', '0', 'shop:productSpec:export',       '#', 'admin', sysdate(), '', null, '');