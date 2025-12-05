import request from '@/utils/request'

// 查询会员卡信息列表
export function listVipCard(query) {
  return request({
    url: '/shop/vipCard/list',
    method: 'get',
    params: query
  })
}

// 查询会员卡信息详细
export function getVipCard(cardId) {
  return request({
    url: '/shop/vipCard/' + cardId,
    method: 'get'
  })
}

// 新增会员卡信息
export function addVipCard(data) {
  return request({
    url: '/shop/vipCard',
    method: 'post',
    data: data
  })
}

// 修改会员卡信息
export function updateVipCard(data) {
  return request({
    url: '/shop/vipCard',
    method: 'put',
    data: data
  })
}

// 删除会员卡信息
export function delVipCard(cardId) {
  return request({
    url: '/shop/vipCard/' + cardId,
    method: 'delete'
  })
}
