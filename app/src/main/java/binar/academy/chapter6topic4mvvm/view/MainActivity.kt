package binar.academy.chapter6topic4mvvm.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import binar.academy.chapter6topic4mvvm.R
import binar.academy.chapter6topic4mvvm.databinding.ActivityMainBinding
import binar.academy.chapter6topic4mvvm.viewmodel.ViewModelCars

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var carAdapter: AdapterCars

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setVmtoAdapter()
    }

    fun setVmtoAdapter(){
        val viewModel = ViewModelProvider(this).get(ViewModelCars::class.java)
        viewModel.callApiCar()
        viewModel.getliveDataCar().observe(this, Observer {
            carAdapter = AdapterCars(it)
            if ( it != null){
                binding.rvCar.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
                binding.rvCar.adapter = AdapterCars(it)

            }
        })
    }
}