package com.testmodule.testKotlin.testdemo

fun main(args: Array<String>) {
    val contacts = listOf(Person("Dmitry", "Jemerov", "123-4567"), Person("Svetlana", "Dmakova", null))
    val contactListFilters = ContactListFilters()
    with(contactListFilters) {
        prefix = "Dm"
        onlyWithPhoneNumber = false
    }
    println(contacts.filter(contactListFilters.getPredicate()))

}

data class Person(
        val firstName: String,
        val lastName: String,
        val phoneNumber: String?
)

class ContactListFilters {
    var prefix: String = ""
    var onlyWithPhoneNumber: Boolean = false

    // 定义一个返回值为另一个函数A的函数B
    // 这个函数A的入参是Person，返回值是Boolean，所以函数B的返回值也是Boolean类型

    // 方法1：一个参数
    fun getPredicate(): (Person) -> Boolean {
        val startsWithPrefix = { p: Person ->
            p.firstName.startsWith(prefix) || p.lastName.startsWith(prefix)
        }
        if (!onlyWithPhoneNumber) {
            //[1] 可替换
            return startsWithPrefix
        }
        return {
            startsWithPrefix(it) && it.phoneNumber != null
        }
    }
    // 方法2：两个参数
    fun getPredicate2(): (Boolean, Person) -> Boolean {
        val startsWithPrefix = { b: Boolean, p: Person ->
            p.firstName.startsWith(prefix) || p.lastName.startsWith(prefix)
        }
        if (!onlyWithPhoneNumber) {
            //[1] 可替换
            return startsWithPrefix
        }
        return { b, p ->
            startsWithPrefix(b, p) && p.phoneNumber != null
        }
    }
}