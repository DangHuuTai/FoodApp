package com.example.foodapp.Movie.Fragments

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.foodapp.Movie.Movie
import com.example.foodapp.R
import com.squareup.picasso.Picasso

class NowPlayingFragmentAdapter(val data : List<Movie>?) : RecyclerView.Adapter<NowPlayingFragmentAdapter.ViewHolder>(){

    private val LIST_ITEM : Int = 0
    private val GRID_ITEM : Int = 1
    private var isSwitch : Boolean = false




    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var layoutInflater = LayoutInflater.from(parent.context)
        var view : View = if(viewType == LIST_ITEM)
            layoutInflater.inflate(R.layout.movie_linear_item, parent, false)
        else
            layoutInflater.inflate(R.layout.movie_grid_item, parent, false)
        return ViewHolder(view)
    }

    fun switchItemView() : Boolean
    {
        isSwitch = !isSwitch
        return isSwitch
    }

    override fun getItemViewType(position: Int): Int {
        return if (isSwitch){
            LIST_ITEM
        }else{
            GRID_ITEM;
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var item = data?.get(position)
        holder.title.text = item?.title
        holder.description.text = item?.overview
        Picasso.get().load(item?.posterPath).into(holder.poster)
    }

    override fun getItemCount(): Int {
        return data?.size ?: 0
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val poster = itemView.findViewById<ImageView>(R.id.poster_img)
        val title = itemView.findViewById<TextView>(R.id.title_txt)
        val description = itemView.findViewById<TextView>(R.id.description_txt)
    }
}