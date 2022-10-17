package binar.academy.chapter6topic4mvvm.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import binar.academy.chapter6topic4.model.getAllCarsItem
import binar.academy.chapter6topic4.network.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ViewModelCars: ViewModel() {

    lateinit var liveDataCar: MutableLiveData<List<getAllCarsItem>>

    init {
        liveDataCar = MutableLiveData()
    }

    fun getliveDataCar(): MutableLiveData<List<getAllCarsItem>> {
        return liveDataCar
    }

    fun callApiCar(){
        ApiClient.instance.getAllCar()
            .enqueue(object : Callback<List<getAllCarsItem>> {
                override fun onResponse(
                    call: Call<List<getAllCarsItem>>,
                    response: Response<List<getAllCarsItem>>
                ) {
                    if (response.isSuccessful){
                        liveDataCar.postValue(response.body())
                    }else{
                        liveDataCar.postValue(null)
                    }
                }

                override fun onFailure(call: Call<List<getAllCarsItem>>, t: Throwable) {
                    liveDataCar.postValue(null)
                }

            })
    }
}