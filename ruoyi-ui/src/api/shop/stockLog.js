import request from '@/utils/request'

// 查询库存流水列表
export function listStockLog(query) {
  return request({
    url: '/shop/stockLog/list',
    method: 'get',
    params: query
  })
}

// 查询库存流水详细
export function getStockLog(logId) {
  return request({
    url: '/shop/stockLog/' + logId,
    method: 'get'
  })
}

// 新增库存流水
export function addStockLog(data) {
  return request({
    url: '/shop/stockLog',
    method: 'post',
    data: data
  })
}

// 修改库存流水
export function updateStockLog(data) {
  return request({
    url: '/shop/stockLog',
    method: 'put',
    data: data
  })
}

// 删除库存流水
export function delStockLog(logId) {
  return request({
    url: '/shop/stockLog/' + logId,
    method: 'delete'
  })
}
