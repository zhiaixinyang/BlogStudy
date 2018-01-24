package blog.com.blogstudy.kotlin.adapter

import android.graphics.BitmapFactory
import android.graphics.drawable.Drawable
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import blog.com.blogstudy.R
import blog.com.blogstudy.kotlin.model.KotlinModel

/**
 * Created by MDove on 18/1/24.
 */
class KotlinAdapter(val data: List<KotlinModel>) : RecyclerView.Adapter<KotlinAdapter.ViewHolder>() {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        //List可以用数组的取值方法
        holder.textView.text = data[position].title
        holder.imageView.setImageBitmap(BitmapFactory.decodeResource(holder.itemView.resources, data[position].url))
    }

    override fun getItemCount(): Int = data.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflate = LayoutInflater.from(parent.context).inflate(R.layout.item_kotlin, parent, false)
        return ViewHolder(inflate)
    }


    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textView: TextView
        val imageView: ImageView

        init {
            textView = itemView.findViewById(R.id.tv_kotlin) as TextView
            imageView = itemView.findViewById(R.id.iv_kotlin) as ImageView
        }
    }
}