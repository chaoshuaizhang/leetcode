package com.testmodule.testKotlin

sealed class Animal {
    class Dog(val meet: String) : Animal(){
        fun ken(){
            println("小狗啃骨头")
        }
    }
    class Cat(val fish: String) : Animal(){
        fun tian(){
            println("小猫舔小鱼")
        }
    }
    class Rabbit(val vegetable: String) : Animal(){
        fun chi(){
            println("小兔吃青菜")
        }
    }
}

class Fish : Animal(){
    fun eat() {
        println("小鱼吃虾米")
    }
}