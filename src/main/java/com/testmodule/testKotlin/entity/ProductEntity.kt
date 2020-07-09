package com.testmodule.testKotlin.entity

import java.io.Serializable
import java.math.BigDecimal

data class ProductEntity(
        val productSid: Int,
        val categorySid: Int,
        var categoryName: String
) : BaseEntity<String>(), Serializable {
    lateinit var shopName: String
    lateinit var currentPrice: BigDecimal

    override fun toString(): String {
        return super.toString()
    }
}