package com.testmodule.testKotlin

import java.util.ArrayList

class TestKotlin {
    internal var listStr: List<String> = ArrayList()

    private class InnerStaticClass {
        private fun innerFun() {}
    }

    private inner class InnerClass {
        private fun `fun`() {}
    }

    companion object {
        //kotlin的list是不可变的，若要可变，需用mutable类型
        internal var listInt: MutableList<Int> = mutableListOf()
        @JvmStatic
        fun main(args: Array<String>) {
            println("Test Kotlin")
            listInt.add(123)
            listInt.add(235)
            for (i in listInt.indices) {
                val integer = listInt[i]
                println(integer)
            }
        }

    }

}

internal class OutKotlinClass {
    fun getStr(str: String): String {
        return str
    }
}
