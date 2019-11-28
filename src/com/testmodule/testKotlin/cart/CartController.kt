package com.testmodule.testKotlin.cart

import com.testmodule.testKotlin.LogUtil
import com.testmodule.testKotlin.Logger
import com.testmodule.testKotlin.entity.ProductEntity
import com.testmodule.testKotlin.service.ICartService
import com.testmodule.testKotlin.service.impl.CartServiceImpl

class CartController {
    private val logger = LogUtil(Logger())
    private lateinit var cartService: ICartService

    private fun getCartService(): ICartService {
        if (!::cartService.isInitialized) {
            cartService = CartServiceImpl()
        }
        return cartService
    }

    fun addCart(item: ProductEntity) {
        getCartService().addCart(item)
    }

    fun deleteCartItem() {}

    fun deleteAllCarts() {}

}