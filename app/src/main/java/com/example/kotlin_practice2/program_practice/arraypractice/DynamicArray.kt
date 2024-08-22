package com.example.kotlin_practice2.program_practice.arraypractice

open class DynamicArray {
    private var array = arrayOfNulls<String?>(1)
    private var capacity = 1
    private var length = 0

    fun push(string: String){
        if (length == capacity){
            val tempArray = arrayOfNulls<String>(2*capacity)
            for (i in 0 until array.size-1){
                tempArray[i] = array[i]
            }
            array = tempArray
            capacity = 2*capacity
        }
        array[length] = string
        length +=1
    }
    fun get(index:Int):String?{
        return if (index>=0 && index<length) array[index] else "ArrayException"
    }
}

fun main(){
    val dm = DynamicArray()
    dm.push("rahul")
    print(dm.get(0))
}