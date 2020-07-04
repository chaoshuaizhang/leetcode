package com.testmodule.testKotlin.testdemo

import com.testmodule.testKotlin.enums.ShopEnums

fun main() {
    i(1)
    i(1.5)
    i('A')
    i("B")
}

// inline的作用：
// reified的作用：
inline fun <reified A : Any> i(t: A) {
    println(t)
}