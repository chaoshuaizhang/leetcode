package com.testmodule.testKotlin

import com.testmodule.testKotlin.cart.CartController
import com.testmodule.testKotlin.cart.Carts
import com.testmodule.testKotlin.entity.ProductEntity
import kotlin.test.todo

// kotlin中的main函数写在类里会被认为是一个普通的函数

fun main(args: Array<String>) {
    val log = LogUtil(Logger())
    log.info("----- 千秋万载 一统江湖 -----")
    val pro = ProductEntity(1, 1002, 100234,
            "AE86", 100001, "外套")
    var cartController = CartController()
    cartController.addCart(pro)
    cartController.addCart(pro)
    log.info("购物车数量 ${Carts.map.size}")
    log.info("购物车数量 ${Carts.map}")

}