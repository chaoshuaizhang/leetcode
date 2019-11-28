package com.testmodule.testKotlin.service.impl

import com.testmodule.testKotlin.LogUtil
import com.testmodule.testKotlin.Logger
import com.testmodule.testKotlin.cart.Carts
import com.testmodule.testKotlin.entity.ProductEntity
import com.testmodule.testKotlin.enums.ShopEnums
import com.testmodule.testKotlin.service.ICartService

class CartServiceImpl : ICartService {

    private val logger: LogUtil = LogUtil(Logger())

    override fun addCart(item: ProductEntity) {
        if (item.categoryName.equals("外套"))
            item.categoryName = "加厚版外套"
        else
            item.categoryName = "普通${item.categoryName}"

        // 对门店进行处理
        when (item.shopSid) {
            1002 -> {
                logger.info("上品+门店需要单独处理")
                item.shopName = "上品奥莱Mall"
            }
            1008 -> logger.info("1008门店不做处理")
            // 这里是不需要调用toString的，但是getShopName返回的类型是String?，无
            // 法接收，是能借助于toString，可以看下toString的源码
            else -> item.shopName = ShopEnums.getShopName(1).toString()
        }
        // 对门店供应商相同的商品进行合并
        val key = "${item.shopSid}${item.supplySid}"
        logger.info("加入购物车之前的数量：${Carts.map[key]?.size}")
        when (Carts.map.containsKey(key)) {
            true -> Carts.map[key]?.add(item)
            false->{
                val list = mutableListOf<ProductEntity>()
                list.add(item)
                Carts.map[key] = list
            }
        }
        logger.info("加入购物车之后的数量：${Carts.map[key]?.size}")
    }

    override fun deleteCartItem(proSid: Int, count: Int) {
    }

    override fun deleteAllCarts() {
        println("删除购物车")
    }

}