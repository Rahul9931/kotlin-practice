package com.example.kotlin_practice2.program_practice
fun main(){
    var k = 0
    for (i in 1..9){
        if(i<6) k++ else k--
        for (j in 1..5){
            if (j>=6-k){
                print("*")
            }
            else{
                print(" ")
            }
        }
        println()
    }
}