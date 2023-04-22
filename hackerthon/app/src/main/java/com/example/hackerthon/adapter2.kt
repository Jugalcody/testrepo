package com.example.hackerthon

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class adapter2(val context:Context,val itemList:ArrayList<issueClass>):RecyclerView.Adapter<adapter2.db>() {
    class db(view: View):RecyclerView.ViewHolder(view){

        val issueid=view.findViewById<TextView>(R.id.issueid)
        val issue=view.findViewById<TextView>(R.id.issue)
        val owner=view.findViewById<TextView>(R.id.owner22)
        val action=view.findViewById<Button>(R.id.action)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): db {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.issue_name,parent,false)
        return db(view)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onBindViewHolder(holder: db, position: Int) {
        val a=itemList[position]
holder.issueid.text="Issue ID : ${a.issueId}"
        holder.issue.text="Issue : ${a.issue}"
        holder.owner.text="Citizen : ${a.citizen}"
        holder.action.setOnClickListener{
            holder.action.setText("Taking Action...")
        }
    }


}