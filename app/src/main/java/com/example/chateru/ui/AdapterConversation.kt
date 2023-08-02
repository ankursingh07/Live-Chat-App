package com.example.chateru.ui

import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.chateru.R

class AdapterConversation(private val listener: OnItemClickListener?) : RecyclerView.Adapter<AdapterConversation.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.layout_conversation,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return 10
    }

    override fun onBindViewHolder(holder: AdapterConversation.ViewHolder, position: Int) {

    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) , View.OnClickListener{

        private val itemLayout = itemView.findViewById(R.id.conversation_tile) as ConstraintLayout

        init {
            itemLayout.setOnClickListener(this)
        }

        override fun onClick(p0: View?) {
            val position = adapterPosition
            listener?.onItemClick(position)
        }

    }

    interface OnItemClickListener {
        fun onItemClick(position: Int)
        fun onDeleteClick(position: Int)
    }
}