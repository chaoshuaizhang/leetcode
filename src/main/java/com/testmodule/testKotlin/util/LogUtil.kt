package com.testmodule.testKotlin.util

/*
* 定义一个日志接口
* */
interface BaseLog {
    fun info(info: String)
    fun error(error: String)
}

/*
* 定义一个具体的实现类
* */
class Logger : BaseLog {
    override fun info(info: String) {
        println("INFO : $info")
    }

    override fun error(error: String) {
        println("ERROR : $error")
    }

}

/*
*
* */
class LogUtil(myLogger: BaseLog) : BaseLog by myLogger {

    /*
    * 定义一个自己的方法，委托类中不存在这个方法
    * */
    fun debug(msg: String) {
        println(msg)
    }

    /*
    * 重写委托类的方法
    * */
    override fun error(error: String) {
        println("不使用委托的方法，使用自定义的方法：$error")
    }

}

class CountingSet<T>(val innerSet: HashSet<T> = HashSet<T>())

class SAD constructor(val aa: Any = String())