import request from '@/utils/request'

// 查询库存信息列表
export function listStock(query) {
  return request({
    url: '/shop/stock/list',
    method: 'get',
    params: query
  })
}

// 查询库存信息详细
export function getStock(stockId) {
  return request({
    url: '/shop/stock/' + stockId,
    method: 'get'
  })
}

// 新增库存信息
export function addStock(data) {
  return request({
    url: '/shop/stock',
    method: 'post',
    data: data
  })
}

// 修改库存信息
export function updateStock(data) {
  return request({
    url: '/shop/stock',
    method: 'put',
    data: data
  })
}

// 删除库存信息
export function delStock(stockId) {
  return request({
    url: '/shop/stock/' + stockId,
    method: 'delete'
  })
}
