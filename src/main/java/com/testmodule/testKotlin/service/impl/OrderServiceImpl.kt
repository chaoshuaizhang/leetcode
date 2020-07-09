package com.testmodule.testKotlin.service.impl

import com.alibaba.fastjson.JSONArray
import com.alibaba.fastjson.JSONObject
import com.google.gson.Gson
import com.google.gson.JsonObject
import com.testmodule.testKotlin.entity.CartEntity
import com.testmodule.testKotlin.entity.OrderDetailEntity
import com.testmodule.testKotlin.entity.OrderEntity
import com.testmodule.testKotlin.repository.DataRepository
import com.testmodule.testKotlin.service.IOrderService
import com.testmodule.testKotlin.util.LogUtil
import com.testmodule.testKotlin.util.Logger
import com.testmodule.testKotlin.util.R
import java.math.BigDecimal
import java.util.*

class OrderServiceImpl : IOrderService {
    private val logger: LogUtil = LogUtil(Logger())

    override fun createOrder(date: Date, carts: Map<String, List<CartEntity>>): OrderEntity {
        // 订单实例
        val jsonObj = JSONObject()
        val orderNo = "20191130${date.time}"
        var details = generateOrderDetail(DataRepository.cartMap)
        jsonObj["orderNo"] = orderNo
        jsonObj["saleSum"] = (details["list"] as List<Any>).size
        jsonObj["moneySum"] = (details["moneySum"] as BigDecimal).setScale(2, BigDecimal.ROUND_HALF_UP)
        jsonObj["orderDetails"] = details.get("list")
        var jsonStr = Gson().toJson(jsonObj)
        logger.info("转换为string串 $jsonStr")
        return Gson().fromJson(jsonStr, OrderEntity::class.java)
    }

    override fun generateOrderDetail(carts: Map<String, List<CartEntity>>): Map<String, Any> {
        val details = JSONArray()
        var moneySum = BigDecimal(0)
        // 强行使用局部函数
        fun initDetails() {
            carts.forEach { _, v ->
                v.forEach {
                    // 这块儿把实例对象转为string的，fastjson有点耗时，gson速度还行
                    val s = JSONObject.toJSONString(it)
                    val obj = JSONObject.parseObject(s, OrderDetailEntity::class.java)
                    obj.proSum = 1
                    obj.proSku = "订单明细-SKU"
                    moneySum = moneySum.add(BigDecimal(obj.promotionPrice.toDouble() * obj.proSum))
                    details.add(obj)
                }
            }
        }
        initDetails()
        var j = JSONObject()
        var list = j.toList(Gson().toJson(details), OrderDetailEntity::class.java)
        list.maxBy {
            it.proSku
        }
        list.maxBy {
            it: OrderDetailEntity -> it.proSku
        }
        list.maxBy() {
            it.proSum
        }
        list.maxBy({ it.proSum })
        return mapOf("moneySum" to moneySum, "list" to list)
    }

    /*
    * 使用扩展函数（强行使用）
    * 可以在扩展函数中调用被扩展函数的其它方法（就像在扩展函数内部一样）
    * */
    fun <T> JSONObject.toList(o: Any, clazz: Class<T>): List<T> = JSONObject.parseArray(o as String, clazz)

    override fun updateOrderStatus(orderNo: String) {
    }

    override fun deleteOrderStatus() {
    }
}