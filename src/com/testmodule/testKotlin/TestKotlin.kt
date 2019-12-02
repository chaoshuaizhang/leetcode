package com.testmodule.testKotlin

import com.google.gson.Gson
import com.testmodule.testKotlin.cart.CartController
import com.testmodule.testKotlin.entity.Base
import com.testmodule.testKotlin.entity.ProductEntity
import com.testmodule.testKotlin.order.OrderController
import com.testmodule.testKotlin.repository.DataRepository
import com.testmodule.testKotlin.util.LogUtil
import com.testmodule.testKotlin.util.Logger
import javafx.application.Application.launch
import kotlinx.coroutines.*
import java.math.BigDecimal
import java.util.*
import kotlin.random.Random

// kotlin中的main函数写在类里会被认为是一个普通的函数

fun main(args: Array<String>) = runBlocking {
    val log = LogUtil(Logger())
    log.info("----- 购物流程 -----")
    val proGenerateLaunch = GlobalScope.async {
        var p = ProductEntity(1, 100001, "外套")
        p.shopSid = 1001
        p.supplySid = 100234
        p.currentPrice = BigDecimal(Random.nextDouble(150.0, 200.0))
                .setScale(2, BigDecimal.ROUND_HALF_UP)
        p
    }
    var cartController = CartController()
    val pro = proGenerateLaunch.await()
    log.info(pro.toString())
    cartController.addCart(pro)
    log.info("购物车数量 ${DataRepository.cartMap.size}")
    log.info("开始创建订单")
    var orderController = OrderController(Logger())
    val createOrder = orderController.createOrder(Date(), DataRepository.cartMap)
    log.info("订单创建完成${Gson().toJson(createOrder)}")

    var b = Base<String>()
    b.i("111")
    b.i(111)
    b.i(111.15)
}

suspend fun a() {
    delay(1000)
    launch()
}

class ProductGenerator {
    fun generatePro(): ProductEntity? {
        "12qw123".filter {
            it == '1' || it == 'q'
        }
        return null
    }

    fun String.filter(predicate: (Char) -> Boolean): String {
        val sb = StringBuilder()
        for (index in 0 until length) {
            if (predicate(get(index))) {
                println("相等 $index")
            } else {
                println("不等 $index")
            }
        }
        return sb.toString()
    }
}