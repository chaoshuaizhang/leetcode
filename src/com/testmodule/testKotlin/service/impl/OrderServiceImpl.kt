package com.testmodule.testKotlin.service.impl

import com.alibaba.fastjson.JSONArray
import com.alibaba.fastjson.JSONObject
import com.google.gson.Gson
import com.testmodule.testKotlin.entity.CartEntity
import com.testmodule.testKotlin.entity.OrderDetailEntity
import com.testmodule.testKotlin.entity.OrderEntity
import com.testmodule.testKotlin.repository.DataRepository
import com.testmodule.testKotlin.service.IOrderService
import com.testmodule.testKotlin.util.LogUtil
import com.testmodule.testKotlin.util.Logger
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
        jsonObj["saleSum"] = details.size
        jsonObj["moneySum"] = (details["moneySum"] as BigDecimal).setScale(2, BigDecimal.ROUND_HALF_UP)
        jsonObj["orderDetails"] = details.get("list")
        var jsonStr = Gson().toJson(jsonObj)
        logger.info("转换为string串 $jsonStr")
        return Gson().fromJson(jsonStr, OrderEntity::class.java)
    }

    override fun generateOrderDetail(carts: Map<String, List<CartEntity>>): Map<String, Any> {
        val details = JSONArray()
        var moneySum = BigDecimal(0)
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
        var list = JSONObject.parseArray(Gson().toJson(details), OrderDetailEntity::class.java)
        return mapOf("moneySum" to moneySum, "list" to list)
    }

    override fun updateOrderStatus(orderNo: String) {
    }

    override fun deleteOrderStatus() {
    }
}