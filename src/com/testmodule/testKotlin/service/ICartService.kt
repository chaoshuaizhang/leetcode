package com.testmodule.testKotlin.service

import com.testmodule.testKotlin.entity.ProductEntity

interface ICartService {
    fun addCart(cartItem: ProductEntity)

    fun deleteCartItem(proSid: Int, count: Int)

    fun deleteAllCarts()
}