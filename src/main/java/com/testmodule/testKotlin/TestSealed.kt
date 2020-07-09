package com.testmodule.testKotlin

fun testAnimal(animal: Animal) = when (animal) {
    is Animal.Dog -> {
        animal.ken()
    }
    is Animal.Cat -> {
        animal.tian()
    }
    is Animal.Rabbit -> {
        animal.chi()
    }
    is Fish -> {
        animal.eat()
    }
}

fun main() {
    println("----------")
    var cat = Animal.Cat("鱼")
    var pig = Pig()
    testAnimal(cat)
}

class Pig