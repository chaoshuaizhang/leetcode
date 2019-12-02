package com.testmodule.testKotlin.service.impl

import com.testmodule.testKotlin.util.LogUtil
import com.testmodule.testKotlin.util.Logger
import com.testmodule.testKotlin.entity.CartEntity
import com.testmodule.testKotlin.entity.ProductEntity
import com.testmodule.testKotlin.enums.ShopEnums
import com.testmodule.testKotlin.repository.DataRepository
import com.testmodule.testKotlin.service.ICartService
import java.math.BigDecimal
import kotlin.random.Random

class CartServiceImpl : ICartService {

    private val logger: LogUtil = LogUtil(Logger())
    private val cardArr = arrayOf("5365829103", "5264060125", "0136947586")

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
        // 生成一个购物车商品实例
        val cartItem = CartEntity(cardArr[Random.nextInt(3)])
        cartItem.let {
            cartItem.shopSid = item.shopSid
            cartItem.supplySid = item.supplySid
            cartItem.brandSid = item.brandSid
            cartItem.productSid = item.productSid
            cartItem.currentPrice = item.currentPrice
            cartItem.promotionPrice = BigDecimal(item.currentPrice.toDouble() * 0.8)
                    .setScale(2,BigDecimal.ROUND_HALF_UP)
            cartItem.tag = 1
        }
        // 对门店供应商相同的商品进行合并
        val key = "${cartItem.shopSid}${cartItem.supplySid}"
        logger.info("加入购物车之前的数量：${DataRepository.cartMap[key]?.size}")
        when (DataRepository.cartMap.containsKey(key)) {
            true -> DataRepository.cartMap[key]?.add(cartItem)
            false -> {
                val list = mutableListOf<CartEntity>()
                list.add(cartItem)
                DataRepository.cartMap[key] = list
            }
        }
        logger.info("加入购物车之后的数量：${DataRepository.cartMap[key]?.size}")
    }

    override fun deleteCartItem(proSid: Int) {
        var tag: String? = null
        DataRepository.cartMap.forEach { k, v ->
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
        tag?.let { DataRepository.cartMap.remove(tag!!) }
    }

    override fun deleteAllCarts() {
        DataRepository.cartMap.clear()
    }

    override fun showCarts(): MutableMap<String, List<ProductEntity>> {
        return mutableMapOf()
    }

}