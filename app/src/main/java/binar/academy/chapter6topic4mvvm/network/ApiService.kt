package binar.academy.chapter6topic4.network

import binar.academy.chapter6topic4.model.getAllCarsItem
import retrofit2.Call
import retrofit2.http.*

interface ApiService {

    @GET("admin/car")
    fun getAllCar(): Call<List<getAllCarsItem>>
}