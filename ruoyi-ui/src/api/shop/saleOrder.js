import request from '@/utils/request'

// 查询销售订单列表
export function listSaleOrder(query) {
  return request({
    url: '/shop/saleOrder/list',
    method: 'get',
    params: query
  })
}

// 查询销售订单详细
export function getSaleOrder(orderId) {
  return request({
    url: '/shop/saleOrder/' + orderId,
    method: 'get'
  })
}

// 新增销售订单
export function addSaleOrder(data) {
  return request({
    url: '/shop/saleOrder',
    method: 'post',
    data: data
  })
}

// 修改销售订单
export function updateSaleOrder(data) {
  return request({
    url: '/shop/saleOrder',
    method: 'put',
    data: data
  })
}

// 删除销售订单
export function delSaleOrder(orderId) {
  return request({
    url: '/shop/saleOrder/' + orderId,
    method: 'delete'
  })
}
