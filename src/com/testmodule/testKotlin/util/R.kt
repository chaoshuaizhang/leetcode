package com.testmodule.testKotlin.util

class R<A : Any> {

    var success = true
    var info: String?
    var data: A?

    /*
    * 只返回true/false
    * */
    constructor(success: Boolean) : this(success, null)

    /*
    * 返回true/false + 描述信息
    * */
    constructor(success: Boolean, info: String?) : this(success, info, null)

    /*
    * 只返回数据 data，默认success = true
    * */
    constructor(data: A?) : this(true, null, data)

    /*
    * 完整的返回格式
    * */
    constructor(success: Boolean, info: String?, data: A?) {
        this.success = success
        this.info = info
        this.data = data
    }

    companion object {
        fun <T : Any> Y(success: Boolean, info: String): R<T> {
            return Y(success, info, null)
        }

        fun <T : Any> Y(data: T): R<T> {
            return Y(true, null, data)
        }

        fun <T : Any> Y(success: Boolean, data: T): R<T> {
            return Y(success, null, data)
        }

        fun <T : Any> Y(success: Boolean, info: String?, data: T?): R<T> {
            return R(success, info, data)
        }

        fun <T : Any> N(success: Boolean, info: String): R<T> {
            return R(success, info, null)
        }

        fun <T : Any> N(success: Boolean, data: T?): R<T> {
            return R(success, null, data)
        }

        fun <T : Any> N(success: Boolean, info: String?, data: T?): R<T> {
            return R(success, info, data)
        }
    }
}