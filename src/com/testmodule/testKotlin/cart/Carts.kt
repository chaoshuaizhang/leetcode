package com.testmodule.testKotlin.cart

import com.testmodule.testKotlin.entity.ProductEntity

/*
* 模拟购物车，存放购物车相关的数据
*/
object Carts {
    val map = mutableMapOf<String, MutableList<ProductEntity>>()
}