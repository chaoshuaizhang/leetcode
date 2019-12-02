package com.testmodule.testKotlin.cart

import com.testmodule.testKotlin.util.LogUtil
import com.testmodule.testKotlin.util.Logger
import com.testmodule.testKotlin.entity.ProductEntity
import com.testmodule.testKotlin.service.ICartService
import com.testmodule.testKotlin.service.impl.CartServiceImpl

class CartController {
    private val logger = LogUtil(Logger())
    private lateinit var cartService: ICartService

    private fun getCartService(): ICartService {
        // service没有初始化时进行初始化
        if (!::cartService.isInitialized) {
            cartService = CartServiceImpl()
        }
        return cartService
    }

    fun addCart(item: ProductEntity) = getCartService().addCart(item)

    fun showCarts() = getCartService().deleteAllCarts()

    fun deleteCartItem(productSid: Int) = getCartService().deleteCartItem(productSid)

    fun deleteAllCarts() = getCartService().deleteAllCarts()

}