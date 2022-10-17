package binar.academy.chapter6topic4mvvm.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import binar.academy.chapter6topic4.model.getAllCarsItem
import binar.academy.chapter6topic4mvvm.R
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_car.view.*

class AdapterCars(private var datacars: List<getAllCarsItem>): RecyclerView.Adapter<AdapterCars.ViewHolder>() {
    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterCars.ViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_car, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemView.nameCar.text = datacars[position].name
        holder.itemView.categoryCar.text = datacars[position].category
        holder.itemView.priceCar.text = datacars[position].price.toString()
        Glide.with(holder.itemView.context).load(datacars[position].image).into(holder.itemView.imgCar)
    }

    override fun getItemCount(): Int {
        return datacars.size
    }
}