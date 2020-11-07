package com.example.minicursoandroid

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.RequestManager

class Adapter(
        private var items: List<Anuncio>,
        private var requestManager: RequestManager
):
    RecyclerView.Adapter<RecyclerView.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
       return AnuncioViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_list_anuncio,parent,false))
    }
    override fun getItemCount(): Int {
        return items.size
    }
    var click:(()->Unit)? =null
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
    val item = items[position]
        holder as AnuncioViewHolder
        requestManager
                .load(item.urlImage)
                .placeholder(holder.image.context.resources.getDrawable(R.drawable.online_shop_icon))
                .error(holder.image.context.resources.getDrawable(R.drawable.online_shop_icon))
                .into(holder.image)

        holder.title.text=item.title
        holder.price.text=String.format("R$%.2f", item.price)
        holder.date.text=item.date
        holder.itemView.setOnClickListener{
            click?.invoke()
        }

    }

class AnuncioViewHolder(item: View):RecyclerView.ViewHolder(item){
    val image=item.findViewById<ImageView>(R.id.image)
    val title=item.findViewById<TextView>(R.id.titulo)
    val price=item.findViewById<TextView>(R.id.preco)
    val date=item.findViewById<TextView>(R.id.data)
}
}