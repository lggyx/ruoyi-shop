-- 清空所有业务表（按依赖关系倒序删除）
SET FOREIGN_KEY_CHECKS = 0; -- 临时关闭外键检查

-- 清空数据并重置自增
TRUNCATE TABLE shop_vip_card;
TRUNCATE TABLE shop_sale_order_detail;
TRUNCATE TABLE shop_sale_order;
TRUNCATE TABLE shop_purchase_order_detail;
TRUNCATE TABLE shop_purchase_order;
TRUNCATE TABLE shop_stock_log;
TRUNCATE TABLE shop_stock;
TRUNCATE TABLE shop_product_spec;
TRUNCATE TABLE shop_product;
TRUNCATE TABLE shop_member;
TRUNCATE TABLE shop_category;
TRUNCATE TABLE shop_supplier;

SET FOREIGN_KEY_CHECKS = 1; -- 恢复外键检查

-- ----------------------------
-- 初始化-供应商信息表数据
-- ----------------------------
INSERT INTO shop_supplier (supplier_id, supplier_name, supplier_code, contact, phone, email, address, status, del_flag, create_by, create_time, update_by, update_time, remark) VALUES
                                                                                                                                                                                    (100, '可口可乐有限公司', 'GYS001', '张三', '13800138001', 'cocacola@email.com', '北京市朝阳区', '0', '0', 'admin', NOW(), '', NULL, '饮料供应商'),
                                                                                                                                                                                    (101, '康师傅食品集团', 'GYS002', '李四', '13800138002', 'ksf@email.com', '天津市开发区', '0', '0', 'admin', NOW(), '', NULL, '食品供应商'),
                                                                                                                                                                                    (102, '宝洁中国有限公司', 'GYS003', '王五', '13800138003', 'pg@email.com', '上海市浦东新区', '0', '0', 'admin', NOW(), '', NULL, '日用品供应商'),
                                                                                                                                                                                    (103, '三只松鼠股份有限公司', 'GYS004', '赵六', '13800138004', '3songshu@email.com', '安徽省芜湖市', '0', '0', 'admin', NOW(), '', NULL, '零食供应商');

-- ----------------------------
-- 初始化-商品分类表数据
-- ----------------------------
INSERT INTO shop_category (category_id, parent_id, ancestors, category_name, category_code, order_num, status, del_flag, create_by, create_time, update_by, update_time, remark) VALUES
                                                                                                                                                                                     (100, 0, '0', '食品饮料', 'SP01', 1, '0', '0', 'admin', NOW(), '', NULL, '食品饮料分类'),
                                                                                                                                                                                     (101, 100, '0,100', '饮料饮品', 'SP0101', 1, '0', '0', 'admin', NOW(), '', NULL, '各类饮料'),
                                                                                                                                                                                     (102, 100, '0,100', '休闲零食', 'SP0102', 2, '0', '0', 'admin', NOW(), '', NULL, '零食小吃'),
                                                                                                                                                                                     (103, 0, '0', '日用百货', 'SP02', 2, '0', '0', 'admin', NOW(), '', NULL, '日用百货分类'),
                                                                                                                                                                                     (104, 103, '0,103', '清洁用品', 'SP0201', 1, '0', '0', 'admin', NOW(), '', NULL, '清洁用品'),
                                                                                                                                                                                     (105, 103, '0,103', '纸品湿巾', 'SP0202', 2, '0', '0', 'admin', NOW(), '', NULL, '纸品湿巾');

-- ----------------------------
-- 初始化-商品信息表数据
-- ----------------------------
INSERT INTO shop_product (product_id, category_id, supplier_id, product_name, product_code, barcode, spec_type, price_in, price_sale, price_vip, unit, brand, origin, shelf_life, warning_stock, main_image, album, description, status, del_flag, create_by, create_time, update_by, update_time, remark) VALUES
                                                                                                                                                                                                                                                                                                               (1000, 101, 100, '可口可乐500ml', 'SP00001', '6901234567890', '0', 2.50, 3.50, 3.20, '瓶', '可口可乐', '北京', 365, 20, '/images/cocacola.jpg', '', '500ml经典可口可乐', '0', '0', 'admin', NOW(), '', NULL, '单规格商品'),
                                                                                                                                                                                                                                                                                                               (1001, 101, 100, '雪碧500ml', 'SP00002', '6901234567891', '0', 2.50, 3.50, 3.20, '瓶', '雪碧', '北京', 365, 20, '/images/sprite.jpg', '', '500ml雪碧', '0', '0', 'admin', NOW(), '', NULL, '单规格商品'),
                                                                                                                                                                                                                                                                                                               (1002, 102, 103, '三只松鼠坚果礼盒', 'SP00003', '6901234567892', '0', 45.00, 68.00, 65.00, '盒', '三只松鼠', '安徽', 180, 10, '/images/nuts.jpg', '', '混合坚果礼盒装', '0', '0', 'admin', NOW(), '', NULL, '单规格商品'),
                                                                                                                                                                                                                                                                                                               (1003, 104, 102, '宝洁洗发水750ml', 'SP00004', '6901234567893', '0', 28.00, 45.00, 42.00, '瓶', '海飞丝', '广东', 720, 15, '/images/shampoo.jpg', '', '去屑洗发水750ml', '0', '0', 'admin', NOW(), '', NULL, '单规格商品'),
                                                                                                                                                                                                                                                                                                               (1004, 102, 101, '康师傅方便面', 'SP00005', '6901234567894', '1', 2.00, 4.00, 3.80, '袋', '康师傅', '天津', 180, 30, '/images/noodles.jpg', '', '康师傅红烧牛肉面', '0', '0', 'admin', NOW(), '', NULL, '多规格商品');

-- ----------------------------
-- 初始化-商品规格表数据
-- ----------------------------
INSERT INTO shop_product_spec (spec_id, product_id, spec_name, spec_code, price_in, price_sale, price_vip, stock, warning_stock, barcode, status, del_flag, create_by, create_time, update_by, update_time, remark) VALUES
                                                                                                                                                                                                                        (1000, 1004, '红烧牛肉面105g', 'SP00005-01', 2.00, 4.00, 3.80, 50, 10, '690123456789401', '0', '0', 'admin', NOW(), '', NULL, ''),
                                                                                                                                                                                                                        (1001, 1004, '香辣牛肉面105g', 'SP00005-02', 2.00, 4.00, 3.80, 30, 10, '690123456789402', '0', '0', 'admin', NOW(), '', NULL, ''),
                                                                                                                                                                                                                        (1002, 1004, '老坛酸菜牛肉面112g', 'SP00005-03', 2.20, 4.50, 4.20, 40, 10, '690123456789403', '0', '0', 'admin', NOW(), '', NULL, '');

-- ----------------------------
-- 初始化-会员信息表数据
-- ----------------------------
INSERT INTO shop_member (member_id, member_no, member_name, phone, email, sex, birthday, points, balance, level, status, del_flag, create_by, create_time, update_by, update_time, remark) VALUES
                                                                                                                                                                                               (1000, 'HY2024120001', '张三', '13800138001', 'zhangsan@email.com', '0', '1990-01-01', 1250, 500.00, '2', '0', '0', 'admin', NOW(), '', NULL, '金卡会员'),
                                                                                                                                                                                               (1001, 'HY2024120002', '李四', '13800138002', 'lisi@email.com', '1', '1992-03-15', 800, 300.00, '1', '0', '0', 'admin', NOW(), '', NULL, '银卡会员'),
                                                                                                                                                                                               (1002, 'HY2024120003', '王五', '13800138003', 'wangwu@email.com', '0', '1988-07-20', 500, 100.00, '0', '0', '0', 'admin', NOW(), '', NULL, '普通会员'),
                                                                                                                                                                                               (1003, 'HY2024120004', '赵六', '13800138004', 'zhaoliu@email.com', '1', '1995-11-08', 2000, 800.00, '3', '0', '0', 'admin', NOW(), '', NULL, '钻石会员');

-- ----------------------------
-- 初始化-会员卡信息表数据
-- ----------------------------
INSERT INTO shop_vip_card (card_id, member_id, card_no, card_type, balance, total_amount, expire_date, status, create_by, create_time, update_by, update_time, remark) VALUES
                                                                                                                                                                           (1000, 1000, 'VIP202412001', '0', 500.00, 500.00, '2025-12-31', '0', 'admin', NOW(), '', NULL, '金卡储值卡'),
                                                                                                                                                                           (1001, 1003, 'VIP202412002', '0', 800.00, 1000.00, '2025-12-31', '0', 'admin', NOW(), '', NULL, '钻石卡储值卡'),
                                                                                                                                                                           (1002, 1002, 'VIP202412003', '1', 200.00, 200.00, '2025-06-30', '0', 'admin', NOW(), '', NULL, '普通次卡');

-- ----------------------------
-- 初始化-库存信息表数据
-- ----------------------------
INSERT INTO shop_stock (stock_id, product_id, spec_id, stock_quantity, freeze_quantity, total_in, total_out, warning_stock, last_in_time, last_out_time, create_by, create_time, update_by, update_time, remark) VALUES
                                                                                                                                                                                                                     (1000, 1000, NULL, 100, 0, 500, 400, 20, NOW(), NOW(), 'admin', NOW(), '', NULL, ''),
                                                                                                                                                                                                                     (1001, 1001, NULL, 80, 0, 400, 320, 20, NOW(), NOW(), 'admin', NOW(), '', NULL, ''),
                                                                                                                                                                                                                     (1002, 1002, NULL, 25, 0, 100, 75, 10, NOW(), NOW(), 'admin', NOW(), '', NULL, ''),
                                                                                                                                                                                                                     (1003, 1003, NULL, 40, 0, 200, 160, 15, NOW(), NOW(), 'admin', NOW(), '', NULL, ''),
                                                                                                                                                                                                                     (1004, 1004, 1000, 50, 0, 200, 150, 10, NOW(), NOW(), 'admin', NOW(), '', NULL, ''),
                                                                                                                                                                                                                     (1005, 1004, 1001, 30, 0, 120, 90, 10, NOW(), NOW(), 'admin', NOW(), '', NULL, ''),
                                                                                                                                                                                                                     (1006, 1004, 1002, 40, 0, 180, 140, 10, NOW(), NOW(), 'admin', NOW(), '', NULL, '');

-- ----------------------------
-- 初始化-采购订单表数据
-- ----------------------------
INSERT INTO shop_purchase_order (order_id, order_no, supplier_id, order_amount, paid_amount, status, order_time, expect_time, audit_by, audit_time, receipt_by, receipt_time, del_flag, create_by, create_time, update_by, update_time, remark) VALUES
                                                                                                                                                                                                                                                    (1000, 'CG202412050001', 100, 250.00, 250.00, '2', NOW(), DATE_ADD(NOW(), INTERVAL 3 DAY), 'admin', NOW(), 'admin', NOW(), '0', 'admin', NOW(), '', NULL, '饮料采购单'),
                                                                                                                                                                                                                                                    (1001, 'CG202412050002', 101, 480.00, 480.00, '2', NOW(), DATE_ADD(NOW(), INTERVAL 2 DAY), 'admin', NOW(), 'admin', NOW(), '0', 'admin', NOW(), '', NULL, '零食采购单'),
                                                                                                                                                                                                                                                    (1002, 'CG202412050003', 102, 560.00, 0.00, '1', NOW(), DATE_ADD(NOW(), INTERVAL 5 DAY), 'admin', NOW(), '', NULL, '0', 'admin', NOW(), '', NULL, '日用品采购单');

-- ----------------------------
-- 初始化-采购订单明细表数据
-- ----------------------------
INSERT INTO shop_purchase_order_detail (detail_id, order_id, product_id, spec_id, buy_price, buy_num, total_amount, receipt_num, status, create_by, create_time, update_by, update_time, remark) VALUES
                                                                                                                                                                                                     (1000, 1000, 1000, NULL, 2.50, 100, 250.00, 100, '2', 'admin', NOW(), '', NULL, ''),
                                                                                                                                                                                                     (1001, 1001, 1002, NULL, 48.00, 5, 240.00, 5, '2', 'admin', NOW(), '', NULL, ''),
                                                                                                                                                                                                     (1002, 1001, 1004, 1000, 2.00, 100, 200.00, 100, '2', 'admin', NOW(), '', NULL, '红烧牛肉面'),
                                                                                                                                                                                                     (1003, 1002, 1003, NULL, 28.00, 20, 560.00, 0, '1', 'admin', NOW(), '', NULL, '');

-- ----------------------------
-- 初始化-销售订单表数据
-- ----------------------------
INSERT INTO shop_sale_order (order_id, order_no, member_id, order_amount, discount_amount, pay_amount, pay_type, status, order_time, pay_time, complete_time, cashier, del_flag, create_by, create_time, update_by, update_time, remark) VALUES
                                                                                                                                                                                                                                             (10000, 'XS202412050001', 1000, 175.00, 0.00, 175.00, '2', '2', NOW(), NOW(), NOW(), 'cashier01', '0', 'cashier01', NOW(), '', NULL, '会员购买'),
                                                                                                                                                                                                                                             (10001, 'XS202412050002', NULL, 68.00, 0.00, 68.00, '0', '2', NOW(), NOW(), NOW(), 'cashier01', '0', 'cashier01', NOW(), '', NULL, '散客购买'),
                                                                                                                                                                                                                                             (10002, 'XS202412050003', 1001, 265.00, 15.00, 250.00, '1', '1', NOW(), NOW(), NULL, 'cashier02', '0', 'cashier02', NOW(), '', NULL, '会员支付宝支付');

-- ----------------------------
-- 初始化-销售订单明细表数据
-- ----------------------------
INSERT INTO shop_sale_order_detail (detail_id, order_id, product_id, spec_id, sale_price, vip_price, buy_num, total_amount, discount, status, create_by, create_time, update_by, update_time, remark) VALUES
                                                                                                                                                                                                          (10000, 10000, 1000, NULL, 3.50, 3.20, 50, 175.00, 0.00, '0', 'cashier01', NOW(), '', NULL, '可口可乐'),
                                                                                                                                                                                                          (10001, 10001, 1002, NULL, 68.00, 65.00, 1, 68.00, 0.00, '0', 'cashier01', NOW(), '', NULL, '坚果礼盒'),
                                                                                                                                                                                                          (10002, 10002, 1001, NULL, 3.50, 3.20, 10, 35.00, 0.00, '0', 'cashier02', NOW(), '', NULL, '雪碧'),
                                                                                                                                                                                                          (10003, 10002, 1004, 1002, 4.50, 4.20, 20, 90.00, 10.00, '0', 'cashier02', NOW(), '', NULL, '老坛酸菜面'),
                                                                                                                                                                                                          (10004, 10002, 1003, NULL, 45.00, 42.00, 2, 90.00, 5.00, '0', 'cashier02', NOW(), '', NULL, '洗发水'),
                                                                                                                                                                                                          (10005, 10002, 1004, 1001, 4.00, 3.80, 13, 52.00, 0.00, '0', 'cashier02', NOW(), '', NULL, '香辣牛肉面');

-- ----------------------------
-- 初始化-库存流水表数据
-- ----------------------------
INSERT INTO shop_stock_log (log_id, product_id, spec_id, change_type, change_num, before_stock, after_stock, order_no, create_by, create_time, remark) VALUES
                                                                                                                                                           (1000, 1000, NULL, '1', 100, 0, 100, 'CG202412050001', 'admin', NOW(), '采购入库'),
                                                                                                                                                           (1001, 1000, NULL, '3', 50, 100, 50, 'XS202412050001', 'cashier01', NOW(), '销售出库'),
                                                                                                                                                           (1002, 1001, NULL, '1', 80, 0, 80, 'CG202412050002', 'admin', NOW(), '采购入库'),
                                                                                                                                                           (1003, 1004, 1000, '1', 50, 0, 50, 'CG202412050001', 'admin', NOW(), '采购入库-红烧牛肉面');