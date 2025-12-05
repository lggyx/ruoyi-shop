-- ----------------------------
-- 1、商品分类表
-- ----------------------------
drop table if exists shop_category;
create table shop_category (
                               category_id   bigint(20)      not null auto_increment    comment '分类ID',
                               parent_id     bigint(20)      default 0                  comment '父分类ID',
                               ancestors     varchar(50)     default ''                 comment '祖级列表',
                               category_name varchar(30)     default ''                 comment '分类名称',
                               category_code varchar(30)     default ''                 comment '分类编码',
                               order_num     int(4)          default 0                  comment '显示顺序',
                               status        char(1)         default '0'                comment '状态（0正常 1停用）',
                               del_flag      char(1)         default '0'                comment '删除标志（0代表存在 2代表删除）',
                               create_by     varchar(64)     default ''                 comment '创建者',
                               create_time   datetime                                   comment '创建时间',
                               update_by     varchar(64)     default ''                 comment '更新者',
                               update_time   datetime                                   comment '更新时间',
                               remark        varchar(500)    default null               comment '备注',
                               primary key (category_id)
) engine=innodb auto_increment=100 comment = '商品分类表';

-- ----------------------------
-- 2、供应商信息表
-- ----------------------------
drop table if exists shop_supplier;
create table shop_supplier (
                               supplier_id   bigint(20)      not null auto_increment    comment '供应商ID',
                               supplier_name varchar(100)    not null                   comment '供应商名称',
                               supplier_code varchar(30)     default ''                 comment '供应商编码',
                               contact       varchar(30)     default ''                 comment '联系人',
                               phone         varchar(11)     default ''                 comment '联系电话',
                               email         varchar(50)     default ''                 comment '邮箱',
                               address       varchar(200)    default ''                 comment '地址',
                               status        char(1)         default '0'                comment '状态（0正常 1停用）',
                               del_flag      char(1)         default '0'                comment '删除标志（0代表存在 2代表删除）',
                               create_by     varchar(64)     default ''                 comment '创建者',
                               create_time   datetime                                   comment '创建时间',
                               update_by     varchar(64)     default ''                 comment '更新者',
                               update_time   datetime                                   comment '更新时间',
                               remark        varchar(500)    default null               comment '备注',
                               primary key (supplier_id)
) engine=innodb auto_increment=100 comment = '供应商信息表';

-- ----------------------------
-- 3、商品信息表
-- ----------------------------
drop table if exists shop_product;
create table shop_product (
                              product_id    bigint(20)      not null auto_increment    comment '商品ID',
                              category_id   bigint(20)      not null                   comment '分类ID',
                              supplier_id   bigint(20)      default null               comment '供应商ID',
                              product_name  varchar(100)    not null                   comment '商品名称',
                              product_code  varchar(50)     default ''                 comment '商品编码',
                              barcode       varchar(50)     default ''                 comment '条形码',
                              spec_type     char(1)         default '0'                comment '规格类型（0单规格 1多规格）',
                              price_in      decimal(10,2)   default 0.00               comment '进货价',
                              price_sale    decimal(10,2)   default 0.00               comment '销售价',
                              price_vip     decimal(10,2)   default 0.00               comment '会员价',
                              unit          varchar(10)     default ''                 comment '单位（个/瓶/斤等）',
                              brand         varchar(50)     default ''                 comment '品牌',
                              origin        varchar(50)     default ''                 comment '产地',
                              shelf_life    int(5)          default 0                  comment '保质期（天）',
                              warning_stock int(5)          default 10                 comment '库存预警值',
                              main_image    varchar(255)    default ''                 comment '主图地址',
                              album         varchar(1000)   default ''                 comment '相册地址',
                              description   text            default null               comment '商品描述',
                              status        char(1)         default '0'                comment '状态（0上架 1下架 2缺货）',
                              del_flag      char(1)         default '0'                comment '删除标志（0代表存在 2代表删除）',
                              create_by     varchar(64)     default ''                 comment '创建者',
                              create_time   datetime                                   comment '创建时间',
                              update_by     varchar(64)     default ''                 comment '更新者',
                              update_time   datetime                                   comment '更新时间',
                              remark        varchar(500)    default null               comment '备注',
                              primary key (product_id)
) engine=innodb auto_increment=1000 comment = '商品信息表';
create index idx_shop_product_name on shop_product(product_name);
create index idx_shop_product_code on shop_product(product_code);
create index idx_shop_product_barcode on shop_product(barcode);

-- ----------------------------
-- 4、商品规格表
-- ----------------------------
drop table if exists shop_product_spec;
create table shop_product_spec (
                                   spec_id       bigint(20)      not null auto_increment    comment '规格ID',
                                   product_id    bigint(20)      not null                   comment '商品ID',
                                   spec_name     varchar(50)     not null                   comment '规格名称（如：红色/大号）',
                                   spec_code     varchar(50)     default ''                 comment '规格编码',
                                   price_in      decimal(10,2)   default 0.00               comment '进货价',
                                   price_sale    decimal(10,2)   default 0.00               comment '销售价',
                                   price_vip     decimal(10,2)   default 0.00               comment '会员价',
                                   stock         int(10)         default 0                  comment '库存数量',
                                   warning_stock int(5)          default 10                 comment '库存预警值',
                                   barcode       varchar(50)     default ''                 comment '规格条码',
                                   status        char(1)         default '0'                comment '状态（0正常 1停用）',
                                   del_flag      char(1)         default '0'                comment '删除标志（0代表存在 2代表删除）',
                                   create_by     varchar(64)     default ''                 comment '创建者',
                                   create_time   datetime                                   comment '创建时间',
                                   update_by     varchar(64)     default ''                 comment '更新者',
                                   update_time   datetime                                   comment '更新时间',
                                   remark        varchar(500)    default null               comment '备注',
                                   primary key (spec_id)
) engine=innodb auto_increment=1000 comment = '商品规格表';

-- ----------------------------
-- 5、库存信息表
-- ----------------------------
drop table if exists shop_stock;
create table shop_stock (
                            stock_id      bigint(20)      not null auto_increment    comment '库存ID',
                            product_id    bigint(20)      not null                   comment '商品ID',
                            spec_id       bigint(20)      default null               comment '规格ID',
                            stock_quantity  int(10)         default 0                  comment '库存数量',
                            freeze_quantity int(10)         default 0                  comment '冻结数量',
                            total_in      int(10)         default 0                  comment '累计入库',
                            total_out     int(10)         default 0                  comment '累计出库',
                            warning_stock int(5)          default 10                 comment '库存预警值',
                            last_in_time  datetime                                   comment '最后入库时间',
                            last_out_time datetime                                   comment '最后出库时间',
                            create_by     varchar(64)     default ''                 comment '创建者',
                            create_time   datetime                                   comment '创建时间',
                            update_by     varchar(64)     default ''                 comment '更新者',
                            update_time   datetime                                   comment '更新时间',
                            remark        varchar(500)    default null               comment '备注',
                            primary key (stock_id),
                            unique key uk_shop_stock_product (product_id, spec_id)
) engine=innodb auto_increment=1000 comment = '库存信息表';

-- ----------------------------
-- 6、库存流水表
-- ----------------------------
drop table if exists shop_stock_log;
create table shop_stock_log (
                                log_id        bigint(20)      not null auto_increment    comment '流水ID',
                                product_id    bigint(20)      not null                   comment '商品ID',
                                spec_id       bigint(20)      default null               comment '规格ID',
                                change_type   char(1)         not null                   comment '变动类型（1入库 2出库 3销售 4退货 5调拨）',
                                change_num    int(10)         not null                   comment '变动数量',
                                before_stock  int(10)         default 0                  comment '变动前库存',
                                after_stock   int(10)         default 0                  comment '变动后库存',
                                order_no      varchar(64)     default ''                 comment '关联订单号',
                                create_by     varchar(64)     default ''                 comment '操作人',
                                create_time   datetime                                   comment '操作时间',
                                remark        varchar(500)    default null               comment '备注',
                                primary key (log_id),
                                key idx_shop_stock_log_product (product_id, spec_id),
                                key idx_shop_stock_log_time (create_time)
) engine=innodb auto_increment=1000 comment = '库存流水表';

-- ----------------------------
-- 7、采购订单表
-- ----------------------------
drop table if exists shop_purchase_order;
create table shop_purchase_order (
                                     order_id      bigint(20)      not null auto_increment    comment '订单ID',
                                     order_no      varchar(64)     not null                   comment '采购单号',
                                     supplier_id   bigint(20)      not null                   comment '供应商ID',
                                     order_amount  decimal(12,2)   default 0.00               comment '订单金额',
                                     paid_amount   decimal(12,2)   default 0.00               comment '已付金额',
                                     status        char(1)         default '0'                comment '订单状态（0待审核 1已审核 2已入库 3已取消）',
                                     order_time    datetime                                   comment '下单时间',
                                     expect_time   datetime                                   comment '预期到货时间',
                                     audit_by      varchar(64)     default ''                 comment '审核人',
                                     audit_time    datetime                                   comment '审核时间',
                                     receipt_by    varchar(64)     default ''                 comment '入库人',
                                     receipt_time  datetime                                   comment '入库时间',
                                     del_flag      char(1)         default '0'                comment '删除标志（0代表存在 2代表删除）',
                                     create_by     varchar(64)     default ''                 comment '创建者',
                                     create_time   datetime                                   comment '创建时间',
                                     update_by     varchar(64)     default ''                 comment '更新者',
                                     update_time   datetime                                   comment '更新时间',
                                     remark        varchar(500)    default null               comment '备注',
                                     primary key (order_id),
                                     unique key uk_shop_purchase_order_no (order_no)
) engine=innodb auto_increment=1000 comment = '采购订单表';

-- ----------------------------
-- 8、采购订单明细表
-- ----------------------------
drop table if exists shop_purchase_order_detail;
create table shop_purchase_order_detail (
                                            detail_id     bigint(20)      not null auto_increment    comment '明细ID',
                                            order_id      bigint(20)      not null                   comment '订单ID',
                                            product_id    bigint(20)      not null                   comment '商品ID',
                                            spec_id       bigint(20)      default null               comment '规格ID',
                                            buy_price     decimal(10,2)   default 0.00               comment '采购单价',
                                            buy_num       int(10)         default 0                  comment '采购数量',
                                            total_amount  decimal(12,2)   default 0.00               comment '小计金额',
                                            receipt_num   int(10)         default 0                  comment '已入库数量',
                                            status        char(1)         default '0'                comment '状态（0待入库 1部分入库 2已入库）',
                                            create_by     varchar(64)     default ''                 comment '创建者',
                                            create_time   datetime                                   comment '创建时间',
                                            update_by     varchar(64)     default ''                 comment '更新者',
                                            update_time   datetime                                   comment '更新时间',
                                            remark        varchar(500)    default null               comment '备注',
                                            primary key (detail_id),
                                            key idx_shop_purchase_detail_order (order_id)
) engine=innodb auto_increment=1000 comment = '采购订单明细表';

-- ----------------------------
-- 9、销售订单表
-- ----------------------------
drop table if exists shop_sale_order;
create table shop_sale_order (
                                 order_id      bigint(20)      not null auto_increment    comment '订单ID',
                                 order_no      varchar(64)     not null                   comment '销售单号',
                                 member_id     bigint(20)      default null               comment '会员ID',
                                 order_amount  decimal(12,2)   default 0.00               comment '订单金额',
                                 discount_amount decimal(12,2) default 0.00               comment '优惠金额',
                                 pay_amount    decimal(12,2)   default 0.00               comment '实付金额',
                                 pay_type      char(1)         default '0'                comment '支付方式（0现金 1支付宝 2微信 3银行卡）',
                                 status        char(1)         default '0'                comment '订单状态（0待支付 1已支付 2已完成 3已退款 4已取消）',
                                 order_time    datetime                                   comment '下单时间',
                                 pay_time      datetime                                   comment '支付时间',
                                 complete_time datetime                                   comment '完成时间',
                                 cashier       varchar(64)     default ''                 comment '收银员',
                                 del_flag      char(1)         default '0'                comment '删除标志（0代表存在 2代表删除）',
                                 create_by     varchar(64)     default ''                 comment '创建者',
                                 create_time   datetime                                   comment '创建时间',
                                 update_by     varchar(64)     default ''                 comment '更新者',
                                 update_time   datetime                                   comment '更新时间',
                                 remark        varchar(500)    default null               comment '备注',
                                 primary key (order_id),
                                 unique key uk_shop_sale_order_no (order_no),
                                 key idx_shop_sale_order_member (member_id)
) engine=innodb auto_increment=10000 comment = '销售订单表';

-- ----------------------------
-- 10、销售订单明细表
-- ----------------------------
drop table if exists shop_sale_order_detail;
create table shop_sale_order_detail (
                                        detail_id     bigint(20)      not null auto_increment    comment '明细ID',
                                        order_id      bigint(20)      not null                   comment '订单ID',
                                        product_id    bigint(20)      not null                   comment '商品ID',
                                        spec_id       bigint(20)      default null               comment '规格ID',
                                        sale_price    decimal(10,2)   default 0.00               comment '销售单价',
                                        vip_price     decimal(10,2)   default 0.00               comment '会员单价',
                                        buy_num       int(5)          default 0                  comment '购买数量',
                                        total_amount  decimal(12,2)   default 0.00               comment '小计金额',
                                        discount      decimal(12,2)   default 0.00               comment '优惠金额',
                                        status        char(1)         default '0'                comment '状态（0正常 1退货）',
                                        create_by     varchar(64)     default ''                 comment '创建者',
                                        create_time   datetime                                   comment '创建时间',
                                        update_by     varchar(64)     default ''                 comment '更新者',
                                        update_time   datetime                                   comment '更新时间',
                                        remark        varchar(500)    default null               comment '备注',
                                        primary key (detail_id),
                                        key idx_shop_sale_detail_order (order_id),
                                        key idx_shop_sale_detail_product (product_id)
) engine=innodb auto_increment=10000 comment = '销售订单明细表';

-- ----------------------------
-- 11、会员信息表
-- ----------------------------
drop table if exists shop_member;
create table shop_member (
                             member_id     bigint(20)      not null auto_increment    comment '会员ID',
                             member_no     varchar(50)     not null                   comment '会员编号',
                             member_name   varchar(30)     not null                   comment '会员名称',
                             phone         varchar(11)     default ''                 comment '手机号码',
                             email         varchar(50)     default ''                 comment '邮箱',
                             sex           char(1)         default '0'                comment '性别（0男 1女 2未知）',
                             birthday      date                                       comment '生日',
                             points        int(10)         default 0                  comment '积分余额',
                             balance       decimal(12,2)   default 0.00               comment '余额',
                             level         char(1)         default '0'                comment '会员等级（0普通 1银卡 2金卡 3钻石）',
                             status        char(1)         default '0'                comment '状态（0正常 1停用）',
                             del_flag      char(1)         default '0'                comment '删除标志（0代表存在 2代表删除）',
                             create_by     varchar(64)     default ''                 comment '创建者',
                             create_time   datetime                                   comment '创建时间',
                             update_by     varchar(64)     default ''                 comment '更新者',
                             update_time   datetime                                   comment '更新时间',
                             remark        varchar(500)    default null               comment '备注',
                             primary key (member_id),
                             unique key uk_shop_member_no (member_no),
                             unique key uk_shop_member_phone (phone)
) engine=innodb auto_increment=1000 comment = '会员信息表';

-- ----------------------------
-- 12、会员卡信息表
-- ----------------------------
drop table if exists shop_vip_card;
create table shop_vip_card (
                               card_id       bigint(20)      not null auto_increment    comment '卡ID',
                               member_id     bigint(20)      not null                   comment '会员ID',
                               card_no       varchar(50)     not null                   comment '卡号',
                               card_type     char(1)         default '0'                comment '卡类型（0储值卡 1次卡）',
                               balance       decimal(12,2)   default 0.00               comment '余额',
                               total_amount  decimal(12,2)   default 0.00               comment '初始金额',
                               expire_date   date                                       comment '过期日期',
                               status        char(1)         default '0'                comment '状态（0正常 1已过期 2已注销）',
                               create_by     varchar(64)     default ''                 comment '创建者',
                               create_time   datetime                                   comment '创建时间',
                               update_by     varchar(64)     default ''                 comment '更新者',
                               update_time   datetime                                   comment '更新时间',
                               remark        varchar(500)    default null               comment '备注',
                               primary key (card_id),
                               unique key uk_shop_vip_card_no (card_no),
                               key idx_shop_vip_card_member (member_id)
) engine=innodb auto_increment=1000 comment = '会员卡信息表';