package com.example.hackerthon

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class adapter(val context:Context,val itemList:ArrayList<govt_sign>):RecyclerView.Adapter<adapter.db>() {
    class db(view: View):RecyclerView.ViewHolder(view){

        val item=view.findViewById<TextView>(R.id.rec1)
        val use=view.findViewById<TextView>(R.id.rec2)
        val price=view.findViewById<TextView>(R.id.rec3)
        val no=view.findViewById<TextView>(R.id.no)
        val but=view.findViewById<TextView>(R.id.butbuy)
        val owner=view.findViewById<TextView>(R.id.owner)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): db {
       val view=LayoutInflater.from(parent.context).inflate(R.layout.item_name,parent,false)
        return db(view)
    }

    override fun getItemCount(): Int {
      return itemList.size
    }

    override fun onBindViewHolder(holder: db, position: Int) {
        val a=itemList[position]
        holder.item.text="Item : ${a.item}"
        holder.price.text="Dicounted price : RS.${a.price}"
        holder.use.text="Use : ${a.use}"
        holder.no.text="ItemId : ${a.no}"
        holder.owner.text="Owner : ${a.owner}"
        holder.but.setOnClickListener {
            Toast.makeText(context, "Order Placed!", Toast.LENGTH_LONG).show();
        }

    }


}