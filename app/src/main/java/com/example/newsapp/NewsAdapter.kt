package com.example.newsapp

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class NewsAdapter(private val context:Context, private val article : List<Article>) : RecyclerView.Adapter<NewsAdapter.Articleviewholder>(){

        class Articleviewholder(itemView: View) : RecyclerView.ViewHolder(itemView){
            val newsImage = itemView.findViewById<ImageView>(R.id.newsImage)
            val newstitle = itemView.findViewById<TextView>(R.id.newstitle)
            val newsdiscription = itemView.findViewById<TextView>(R.id.newsdiscription)
            val name = itemView.findViewById<TextView>(R.id.name)
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Articleviewholder {
       val view = LayoutInflater.from(context).inflate(R.layout.item_layout,parent,false)
        return Articleviewholder(view)
    }
    override fun onBindViewHolder(holder: Articleviewholder, position: Int) {
       val article = article[position]
        holder.newstitle.text = article.title
        holder.newsdiscription.text = article.description
        holder.name.text = article.author
        Glide.with(context).load(article.urlToImage).into(holder.newsImage)
        holder.name.setOnClickListener {
            val intent = Intent(context,DetailActivity::class.java)
            intent.putExtra("URL",article.url)
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
       return article.size
    }
}