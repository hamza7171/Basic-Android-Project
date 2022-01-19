/*
 * Copyright (c) 2022.
 * Created by Ameer Hamza on 19/1/2022
 * Author Ameer Hamza
 */

package com.example.basicandroidproject.interfaces

interface StatusListener {
    fun onSuccess(data: Any?)
    fun onFailure(error: String) {}
    fun onProgress() {}
}