-- 菜单 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('库存流水', '2000', '1', 'stockLog', 'shop/stockLog/index', 1, 0, 'C', '0', '0', 'shop:stockLog:list', '#', 'admin', sysdate(), '', null, '库存流水菜单');

-- 按钮父菜单ID
SELECT @parentId := LAST_INSERT_ID();

-- 按钮 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('库存流水查询', @parentId, '1',  '#', '', 1, 0, 'F', '0', '0', 'shop:stockLog:query',        '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('库存流水新增', @parentId, '2',  '#', '', 1, 0, 'F', '0', '0', 'shop:stockLog:add',          '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('库存流水修改', @parentId, '3',  '#', '', 1, 0, 'F', '0', '0', 'shop:stockLog:edit',         '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('库存流水删除', @parentId, '4',  '#', '', 1, 0, 'F', '0', '0', 'shop:stockLog:remove',       '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('库存流水导出', @parentId, '5',  '#', '', 1, 0, 'F', '0', '0', 'shop:stockLog:export',       '#', 'admin', sysdate(), '', null, '');