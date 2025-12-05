import request from '@/utils/request'

// 查询商品规格列表
export function listProductSpec(query) {
  return request({
    url: '/shop/productSpec/list',
    method: 'get',
    params: query
  })
}

// 查询商品规格详细
export function getProductSpec(specId) {
  return request({
    url: '/shop/productSpec/' + specId,
    method: 'get'
  })
}

// 新增商品规格
export function addProductSpec(data) {
  return request({
    url: '/shop/productSpec',
    method: 'post',
    data: data
  })
}

// 修改商品规格
export function updateProductSpec(data) {
  return request({
    url: '/shop/productSpec',
    method: 'put',
    data: data
  })
}

// 删除商品规格
export function delProductSpec(specId) {
  return request({
    url: '/shop/productSpec/' + specId,
    method: 'delete'
  })
}
