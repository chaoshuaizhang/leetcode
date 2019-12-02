package com.testmodule.testKotlin.entity

import java.math.BigDecimal

class OrderDetailEntity : BaseEntity<String>(){
    // 设置多个构造方法
    var proSum: Int = 0
    lateinit var promotionPrice: BigDecimal
    lateinit var proSku: String
}