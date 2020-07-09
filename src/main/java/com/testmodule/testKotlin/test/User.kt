package com.testmodule.testKotlin.test

// 接口中也可以属性
interface User{
    // 这意味着实现 User 接口的类需要提供一个取得 nickname 值的方式
    // 第一个属性nickname必须在子类中重写，而第二个alias是可以被继承的，可以直接使用。
    val nickname:String
    val alias : String
        get() = "default_value"
}

// 以下提供了几种方法来获得接口中的nickname

class  PrivateUser(override  val  nickname:  String)  :  User

class  SubscribingUser (val  email:  String)  :  User  {

    override val nickname: String
        get() = email.substringBefore("@")
}

class  FacebookUser(val  accountld:  Int)  :  User  {
    override val nickname: String = accountld.toString()+"NO"+alias
}

class 伴生对象 {
    companion object{
        fun getInstance() = 伴生对象
    }

//    companion object 有名字的伴生对象 {
//        fun getInstance() = 伴生对象
//    }
}