package com.testmodule.testKotlin.service

import com.testmodule.testKotlin.entity.CartEntity
import com.testmodule.testKotlin.entity.OrderDetailEntity
import com.testmodule.testKotlin.entity.OrderEntity
import java.util.*

interface IOrderService {
    fun createOrder(date: Date, carts: Map<String, List<CartEntity>>): OrderEntity

    fun generateOrderDetail(carts: Map<String, List<CartEntity>>): Map<String, Any>

    fun updateOrderStatus(orderNo: String)

    fun deleteOrderStatus()


}