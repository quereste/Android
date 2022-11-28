package com.example.shop.adapter

import android.app.PendingIntent.getActivity
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.shop.DetailsActivity
import com.example.shop.R
import com.example.shop.model.Item

class ItemAdapter(private val context: Context, private val dataset: List<Item>) : RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {
    class ItemViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView = view.findViewById(R.id.item_name)
        val imageView: ImageView = view.findViewById(R.id.item_image)
        val button: Button = view.findViewById(R.id.item_details)
    }


    // parent - view group under which list will be attached as a child
    // viewType important if more than one item view type
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item, parent, false)

        return ItemViewHolder(adapterLayout)
    }

    // replace contents with a view
    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = dataset[position]
        holder.textView.text = context.resources.getString(item.nameId)

        val description = context.resources.getString(item.descriptionId)

        holder.imageView.setImageResource(item.imageId)
        holder.button.setOnClickListener() {
            Toast.makeText(this.context, description, Toast.LENGTH_LONG).show()
            val intent: Intent = Intent(this.context, DetailsActivity::class.java)

            intent.putExtra("name", context.resources.getString(item.nameId))
            intent.putExtra("description", context.resources.getString(item.descriptionId))

            this.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return dataset.size
    }
}