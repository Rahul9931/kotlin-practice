package com.example.kotlin_practice2.mvvm_practice.viewmodel

import androidx.lifecycle.ViewModel

class CounterUpdateViewModel : ViewModel() {
    var counter = 0

    fun increment(){
        counter++
    }
}