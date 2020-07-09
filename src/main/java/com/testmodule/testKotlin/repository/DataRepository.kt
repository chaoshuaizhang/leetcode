package com.testmodule.testKotlin.repository

import com.testmodule.testKotlin.entity.CartEntity
import com.testmodule.testKotlin.entity.OrderEntity

object DataRepository {
    /*
    * 模拟购物车，存放购物车相关的数据
    */
    val cartMap = mutableMapOf<String, MutableList<CartEntity>>()

    val orderMap = mutableMapOf<String, OrderEntity>()
}