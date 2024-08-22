package com.example.kotlin_practice2.program_practice

fun main(){
    println("Enter the size of array")
    var size = readLine()!!.toInt()
    var arr =IntArray(size)
    for(i in 0..size-1){
        println("Enter value for arr[$i] : ")
        arr[i] = readLine()!!.toInt()
    }
    for (j in 0..size-1){
        println(" ${arr[j]}")
    }
    println("Enter First index for Interchange")
    var first = readLine()!!.toInt()
    println("Enter Second index for Interchange")
    var second = readLine()!!.toInt()
    arr[first] = arr[first] + arr[second]
    arr[second] = arr[first] - arr[second]
    arr[first] = arr[first] - arr[second]

    for (k in 0..size-1){
        print(" ${arr[k]}")
    }
}