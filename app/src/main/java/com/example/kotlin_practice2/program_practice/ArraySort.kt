package com.example.kotlin_practice2.program_practice
fun main(args: Array<String>) {
    println("Enter the size of array")
    var size = readLine()!!.toInt()
    var arr =IntArray(size)
    for(i in 0..size-1){
        println("Enter value for arr[$i] : ")
        arr[i] = readLine()!!.toInt()
    }
    for (j in 0..size-1){
        print(" ${arr[j]} ")
    }
    println()
    var swap = true
    while(swap){
        swap = false
        for(i in 0 until arr.size-1){
            if(arr[i] > arr[i+1]){
                val temp = arr[i]
                arr[i] = arr[i+1]
                arr[i + 1] = temp

                swap = true
            }
        }
    }

    for (k in 0..arr.size-1) print(" ${arr[k]} ")
}