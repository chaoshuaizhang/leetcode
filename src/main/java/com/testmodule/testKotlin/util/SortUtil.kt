package com.testmodule.testKotlin.util

import net.sourceforge.pinyin4j.PinyinHelper
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType

fun main() {
//    val array = arrayOf("bbb","章魚","ced", "de", "as", "东皇太一","宫本武藏","王昭君","李元芳")
//    SortUtil.sortBrand(array)
//    array.forEach {
//        print("${it}  ")
//    }

    val array1 = arrayOf("*fre", "%dwe", "#gtr", "deqwfe", "g", "fw", "流海", "亚瑟", "吕布", "秋雅", "夏洛", "公孙离", "张良", "孙尚香")
    val datas = mutableListOf<String>()
    val hypyOutFormat = HanyuPinyinOutputFormat()
    hypyOutFormat.caseType = HanyuPinyinCaseType.UPPERCASE
    // 不带音调
    hypyOutFormat.toneType = HanyuPinyinToneType.WITHOUT_TONE
    array1.forEach {
        val c = it[0]
        if (c < 'z') {
            println(c)
        } else {
            val strings = PinyinHelper.toHanyuPinyinStringArray(c, hypyOutFormat)
            datas.add(strings[0])
        }
    }
    println("----------自定义标签-----------")
    // continue效果
    (0..20).forEach continuing@{
        if (it < 10)
            return@continuing
            println(it)
    }
    println("----------使用lambda作为参数的函数的函数名可以作为标签-----------")
    (0..20).forEach {
        if (it < 10)
            return@forEach
            println(it)
    }
    println("---------------------")
    // break效果
    run {
        (0..20).forEach {
            if (it > 3)
                return@run
            println(it)
        }
    }
}

class SortUtil {
    companion object {
        fun sortBrand(array: Array<String>): Array<String> {
            array.sortWith(Comparator { o1, o2 ->
                if (o1[0] < o2[0]) 1
                else -1
            })
            return array
        }
    }
}