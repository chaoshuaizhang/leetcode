package com.testmodule.testKotlin

interface BaseLog {
    fun info(info: String)
    fun error(error: String)
}

class Logger : BaseLog {
    override fun info(info: String) {
        println("INFO : $info")
    }

    override fun error(error: String) {
        println("ERROR : $error")
    }

}

class LogUtil(myLogger: BaseLog) : BaseLog by myLogger