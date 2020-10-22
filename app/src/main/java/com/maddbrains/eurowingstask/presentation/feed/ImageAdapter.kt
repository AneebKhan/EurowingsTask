package com.maddbrains.eurowingstask.presentation.feed

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.maddbrains.eurowingstask.R
import com.maddbrains.eurowingstask.domain.model.Image
import kotlinx.android.synthetic.main.item_image.view.*

class ImageAdapter : RecyclerView.Adapter<ImageAdapter.ImageViewHolder>() {

    private var items: List<Image> = ArrayList()
    private var listener: ((Image) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_image, parent, false)
        return ImageViewHolder(view)
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        val image = items[position]
        holder.bind(image)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun setImageClickListener(listener: (Image) -> Unit) {
        this.listener = listener
    }

    fun setItems(items: List<Image>) {
        this.items = items
        notifyDataSetChanged()
    }

    inner class ImageViewHolder internal constructor(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(img: Image) {
            itemView.apply {
                tvImageDesc.text = img.title
                Glide.with(context).load(img.imageUrl).into(imgFeed)
                setOnClickListener { listener?.invoke(img) }
            }
        }
    }

}