package com.lambdaschool.sprint2_challenge

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.grocery_list_items.view.*

class ShoppingListAdapter (val groceryList: MutableList<ShoppingListModel>) : RecyclerView.Adapter<ShoppingListAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context)
            .inflate(R.layout.grocery_list_items,parent,false) as View)
    }

    override fun getItemCount(): Int {
        return groceryList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val pickedItems = groceryList[position]
        holder.bindModel(pickedItems)

        holder.shoppongItemParent.setOnClickListener {
            pickedItems.isShare = !pickedItems.isShare
            notifyItemChanged(position)
        }
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val shoppingImageView: ImageView = view.grocery_image_view
        val shoppingNameView: TextView = view.grocery_name_view
        val shoppongItemParent: LinearLayout = view. grocery_item_parent


        fun bindModel(pickedItems: ShoppingListModel) {
            shoppingImageView.setImageResource(pickedItems.imageId)
            shoppingNameView.text = pickedItems.groceries
            if (pickedItems.isShare)
                shoppongItemParent.setBackgroundColor(ContextCompat.getColor(itemView.context,R.color.Green))
            else
                shoppongItemParent.setBackgroundColor(ContextCompat.getColor(itemView.context,R.color.White))


        }
    }



}