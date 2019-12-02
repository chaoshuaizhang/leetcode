package com.testmodule.testKotlin.entity

import java.io.Serializable

open class Base<T : Any> {
    lateinit var a: String
    lateinit var t: T
//    'lateinit' modifier is not allowed on properties of a type with nullable upper bound

    inline fun <reified A : Any> i(t: A) {
        println(t)
    }



}