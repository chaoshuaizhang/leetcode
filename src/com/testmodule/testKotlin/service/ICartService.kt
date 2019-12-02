package com.testmodule.testKotlin.service

import com.testmodule.testKotlin.entity.ProductEntity

interface ICartService {
    fun addCart(cartItem: ProductEntity)

    fun showCarts(): MutableMap<String, List<ProductEntity>>

    fun deleteCartItem(proSid: Int)

    fun deleteAllCarts()
}