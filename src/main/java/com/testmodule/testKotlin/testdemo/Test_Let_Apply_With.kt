package com.testmodule.testKotlin.testdemo

import com.alibaba.fastjson.JSONObject

fun main() {
    var obj = JSONObject()
    println(with(obj, {
        put("oldkey", "oldvalue")
        "-----"
    }))
    println(obj.size)
    obj.let {
        it.put("letkey","letvalue")
    }
    println(obj.size)
    testLet(obj)
    println(obj.size)
}

fun test_what(s: () -> String): String = "-----$s"

fun testLet(jsonObject: JSONObject) {
    jsonObject.let {
        if (it.containsKey("oldkey")) {
            it["oldkey"] = "修改了老的值"
        }
        it.put("newkey", "newvalue")
    }
}

fun testWith() {

}

fun testApply() {}

fun appendLetter() = buildString {
    append("A")
    append(",")
    append("B")
    append(",")
    append("C")
}