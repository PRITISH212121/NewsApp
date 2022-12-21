package com.example.newsapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class Adapter(val context: Context,val articles:List <Article>) : RecyclerView.Adapter<Adapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater=LayoutInflater.from(context)
        val view=inflater.inflate(R.layout.item_view,parent,false)
        return ViewHolder(view)
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val article=articles[position]
        holder.headlinestxt.text=article.title
        holder.descrptiontxt.text=article.description
        Glide.with(context).load(article.urlToImage).into(holder.newsimage)
    }
    override fun getItemCount(): Int {
        return articles.size
    }
    class ViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView){
        val newsimage=itemView.findViewById<ImageView>(R.id.newsimage)
        val headlinestxt=itemView.findViewById<TextView>(R.id.headtxt)
        val descrptiontxt=itemView.findViewById<TextView>(R.id.descriptiontxt)
    }
}
