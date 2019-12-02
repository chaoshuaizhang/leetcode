package com.testmodule.testKotlin.entity

import java.io.Serializable

open class BaseEntity<T : Any> {
    // 对泛型T设置一个up bound，否则用lateinit修饰会报错
    lateinit var tag: T

    // 通用的参数
    var shopSid: Int? = 0
    var supplySid: Int = 0
    var brandSid: String? = null
}