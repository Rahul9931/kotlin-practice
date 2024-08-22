package com.example.kotlin_practice2.program_practice

fun main(){
   val obj1 = B(6)
}

open class A{
    constructor(){
        println("super")
    }
    constructor(a:Int){
        println(a)
    }
}

class B: A {
    constructor(){
        println("in B")
    }
    constructor(b:Int): this(){
        println(b)
    }
    fun printme(){
        println("constructor")
    }
}