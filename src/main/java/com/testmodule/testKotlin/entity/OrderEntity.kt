package com.testmodule.testKotlin.entity

import java.math.BigDecimal

class OrderEntity : BaseEntity<Int>() {
    var saleSum = 0
    lateinit var moneySum: BigDecimal
    lateinit var orderNo: String
    lateinit var orderDetails: MutableList<OrderDetailEntity>
    var status = 0
}