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
            false -> {
                val list = mutableListOf<ProductEntity>()
                list.add(item)
                Carts.map[key] = list
            }
        }
        logger.info("加入购物车之后的数量：${Carts.map[key]?.size}")
    }

    override fun deleteCartItem(proSid: Int) {
        var tag: String? = null
        Carts.map.forEach { k, v ->
            val t = v.iterator()
            while (t.hasNext()) {
                // 一次只删除一个元素
                if (t.next().productSid == proSid) {
                    (v.size == 1).let { tag = "${v[0].shopSid}${v[0].supplySid}" }
                    t.remove()
                    break
                }
            }
        }
        // 这块儿很是不解，前边已经限定了只有非空才会执行后边的remove
        // 但后边为什么还是要加 !! 非空断言
        tag?.let { Carts.map.remove(tag!!) }
    }

    override fun deleteAllCarts() {
        Carts.map.clear()
    }

}