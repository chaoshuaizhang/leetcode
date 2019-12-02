package com.testmodule.testKotlin.order

import com.alibaba.fastjson.JSONArray
import com.alibaba.fastjson.JSONObject
import com.google.gson.Gson
import com.testmodule.testKotlin.util.BaseLog
import com.testmodule.testKotlin.entity.CartEntity
import com.testmodule.testKotlin.entity.OrderDetailEntity
import com.testmodule.testKotlin.entity.OrderEntity
import com.testmodule.testKotlin.repository.DataRepository
import com.testmodule.testKotlin.service.IOrderService
import com.testmodule.testKotlin.service.impl.OrderServiceImpl
import com.testmodule.testKotlin.util.R
import java.math.BigDecimal
import java.util.*
import kotlin.collections.List
import kotlin.collections.Map
import kotlin.collections.forEach
import kotlin.collections.set

/*
* 注意，ordercontroller中的日志实现方式和其他controller中的不一样
*/
class OrderController(myLogger: BaseLog) : BaseLog by myLogger {
    private lateinit var orderService: IOrderService

    fun getOrderService(): IOrderService {
        if (!::orderService.isInitialized) {
            orderService = OrderServiceImpl()
        }
        return orderService
    }

    fun createOrder(date: Date, carts: Map<String, List<CartEntity>>): R<OrderEntity> {
        var orderEntity = Gson().fromJson(
                Gson().toJson(getOrderService().createOrder(date, carts)), OrderEntity::class.java)
        // 代支付状态
        orderEntity.status = 2
        DataRepository.orderMap.put(orderEntity.orderNo, orderEntity)
        return R.Y(true, orderEntity)
    }

    /*
    * vararg可变参数
    * */
    fun cancelOrder(vararg orderNos: OrderEntity?) {
        orderNos.forEach {
            it?.status = -1
        }
    }

    fun updateOrderStatus(status: Int, orderNo: String) {
        var orderEntity = DataRepository.orderMap[orderNo]
        orderEntity?.status = status
    }


}
