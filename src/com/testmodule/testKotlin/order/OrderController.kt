package com.testmodule.testKotlin.order

import com.testmodule.testKotlin.BaseLog
import java.util.*

class OrderController(myLogger: BaseLog) : BaseLog by myLogger{
    fun createOrderNo(date: Date){
        info("${date.time} 开始创建订单")
        println("1234567890 ")
        error("创建订单异常")
    }
}
