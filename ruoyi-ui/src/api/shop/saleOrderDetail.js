import request from '@/utils/request'

// 查询销售订单明细列表
export function listSaleOrderDetail(query) {
  return request({
    url: '/shop/saleOrderDetail/list',
    method: 'get',
    params: query
  })
}

// 查询销售订单明细详细
export function getSaleOrderDetail(detailId) {
  return request({
    url: '/shop/saleOrderDetail/' + detailId,
    method: 'get'
  })
}

// 新增销售订单明细
export function addSaleOrderDetail(data) {
  return request({
    url: '/shop/saleOrderDetail',
    method: 'post',
    data: data
  })
}

// 修改销售订单明细
export function updateSaleOrderDetail(data) {
  return request({
    url: '/shop/saleOrderDetail',
    method: 'put',
    data: data
  })
}

// 删除销售订单明细
export function delSaleOrderDetail(detailId) {
  return request({
    url: '/shop/saleOrderDetail/' + detailId,
    method: 'delete'
  })
}
