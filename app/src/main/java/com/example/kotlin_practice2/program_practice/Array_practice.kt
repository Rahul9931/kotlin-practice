package com.example.kotlin_practice2.program_practice

class Array_practice{
    companion object{
        @JvmStatic
        fun main(args: Array<String>) {
//            highOrder(printmsg)
//            highAdd(funAdd)
            highmsg("Hello World", ::msg)
            highAdd(::add)

        }

        val printmsg: ()->Unit = { println("hello kotlin") }
        val funAdd:(Int,Int) -> Int = {a,b -> a+b}
        fun add(x:Int,y:Int):Int{
            return x+y
        }
        fun msg(s:String){
            println(s)
        }

        fun highOrder(f:()->Unit){
            f()
        }
        fun highAdd(funcAdd:(Int,Int)->Int){
            println(funcAdd(5,5))
        }
        fun highmsg(ms:String,funcMsg:(String)->Unit){
            funcMsg(ms)
        }
    }

}
