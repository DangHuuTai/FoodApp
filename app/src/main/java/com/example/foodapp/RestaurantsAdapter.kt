package com.example.foodapp

import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import java.io.InputStream
import java.lang.Exception

class RestaurantsAdapter : RecyclerView.Adapter<RestaurantsAdapter.ViewHolder>(){

    var data : List<Restaurant> = listOf()
        set(value){
            field = value
            notifyDataSetChanged()
        }

    val LIST_ITEM : Int = 0
    val GRID_ITEM : Int = 1
    var isSwitch : Boolean = true

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var layoutInflater = LayoutInflater.from(parent.context)
        var view : View
        if(viewType == LIST_ITEM)
            view = layoutInflater.inflate(R.layout.restaurant_linear_item, parent, false)
        else
            view = layoutInflater.inflate(R.layout.restaurant_grid_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var item = data[position]
        holder.name.text = item.name
        holder.address.text = item.address
        Picasso.get().load(item.pictureLink).into(holder.picture)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun getItemViewType(position: Int): Int {
        if (isSwitch){
            return LIST_ITEM;
        }else{
            return GRID_ITEM;
        }
    }

    fun switchItemView() : Boolean
    {
        isSwitch = !isSwitch
        return isSwitch
    }

    class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        val name = itemView.findViewById<TextView>(R.id.restaurantName)!!
        val address = itemView.findViewById<TextView>(R.id.restaurantAddress)!!
        val picture = itemView.findViewById<ImageView>(R.id.restaurantPic)!!
    }
}