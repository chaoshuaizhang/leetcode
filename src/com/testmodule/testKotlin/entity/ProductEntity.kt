package com.testmodule.testKotlin.entity

import java.io.Serializable

data class ProductEntity(
        val productSid: Int,
        val shopSid: Int,
        val supplySid: Int,
        val brandSid: String,
        val categorySid: Int,
        var categoryName: String
) : Serializable {
    lateinit var shopName: String
    override fun toString(): String {
        return super.toString()
    }
}