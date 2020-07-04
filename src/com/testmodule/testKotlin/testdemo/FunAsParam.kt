package com.testmodule.testKotlin.testdemo

fun main() {
    var p = ProductGenerator()
    println("函数作为参数 ： " + p.generatePro())
}

class ProductGenerator {
    fun generatePro(): String {
        return "12qw123".filter {
            it == '1' || it == 'q'
        }
    }

    fun String.filter(predicate: (Char) -> Boolean): String {
        val sb = StringBuilder()
        for (index in 0 until length) {
            if (predicate(get(index))) {
                println("相等 $index")
                sb.append("${get(index)} ")
            } else {
                println("不等 $index")
            }
        }
        return sb.toString()
    }

    // 注意这个方法的返回值是 (String) -> Int类型，什么类型呢？输入参数为String但是返回值是Int的方法类型
    // 也就是
    fun testReturnFun(string: String): (String) -> Int {
        if (string == "123") {
            return { string -> 1 * 3 + string.length * 6 }
        } else {
            return { string -> 2 }
        }
    }
}