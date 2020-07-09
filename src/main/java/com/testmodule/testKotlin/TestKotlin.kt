package com.testmodule.testKotlin

import com.google.gson.Gson
import com.testmodule.testKotlin.cart.CartController
import com.testmodule.testKotlin.entity.ProductEntity
import com.testmodule.testKotlin.order.OrderController
import com.testmodule.testKotlin.repository.DataRepository
import com.testmodule.testKotlin.testdemo.ProductGenerator
import com.testmodule.testKotlin.util.LogUtil
import com.testmodule.testKotlin.util.Logger
import javafx.application.Application.launch
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
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

    pro.let {
        it.shopSid = 2001
    }
    var a = pro.apply {
        shopSid = 3001
    }
    pro.run {
        shopSid = 5001
    }

    var aaa = pro.also {
        it.shopSid = 6001
    }
    println(aaa.shopSid)
    println(pro.shopSid)
    println("==============================================================")



    log.info(pro.toString())



    cartController.addCart(pro)
    log.info("购物车数量 ${DataRepository.cartMap.size}")
    log.info("开始创建订单")
    var orderController = OrderController(Logger())
    val createOrder = orderController.createOrder(Date(), DataRepository.cartMap)
    log.info("订单创建完成${Gson().toJson(createOrder)}")
    var p = ProductGenerator()
    println("返回函数的函数 ： " + p.testReturnFun("1234567"))
    val ss = listOf("1", "2", "3", "4", "5")
    ss.forEachIndexed { index, s ->
        println("" + index + "  " + s)
    }
    for(i in 5 downTo 0){
        println("---  $i")
    }
    val aa = mutableListOf<String>()
    aa.add("A")
    aa.add("B")
    aa.add("C")
    a(aa.toMutableList())

}

fun a(o:MutableList<Any>){
    o.forEach {
        println("哈哈哈哈   $it")
    }
}

suspend fun a() {
    delay(1000)
    launch()
}



