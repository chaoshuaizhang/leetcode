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

        /*
        * 这一个命名函数代替了之前的一系列不定参数
        * */
        fun <T : Any> Y(success: Boolean = true, info: String = "操作成功！", data: T? = null): R<T> {
            return R(success, info, data)
        }

        fun <T : Any> N(data: T?, success: Boolean = false, info: String = "操作失败！"): R<T> {
            return R(success, info, data)
        }
    }
}