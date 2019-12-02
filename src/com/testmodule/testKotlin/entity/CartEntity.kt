package com.testmodule.testKotlin.entity

import java.math.BigDecimal

class CartEntity(val cardId: String) : BaseEntity<Int>() {
    var productSid: Int? = null
    lateinit var currentPrice: BigDecimal
    lateinit var promotionPrice: BigDecimal
}