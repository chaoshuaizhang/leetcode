package com.testmodule.testKotlin.order

import com.testmodule.testKotlin.BaseLog
import com.testmodule.testKotlin._javatmp.TestJava
import java.util.*

/*
* 注意，ordercontroller中的日志实现方式和其他controller中的不一样
*/
class OrderController(myLogger: BaseLog) : BaseLog by myLogger {
    fun createOrder(date: Date) {
        info("${date.time} 开始创建订单")
        println("1234567890 ")
        error("创建订单异常")
    }

    fun cancelOrder(orderNo: String) {

    }

    fun updateOrderStatus(status: Int) {}


}
