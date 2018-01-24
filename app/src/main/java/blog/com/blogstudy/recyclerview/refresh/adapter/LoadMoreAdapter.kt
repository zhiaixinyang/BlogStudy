package blog.com.blogstudy.recyclerview.refresh.adapter

import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.ProgressBar
import android.widget.TextView

import blog.com.blogstudy.R

/**
 * Created by MDove on 17/12/15.
 */

class LoadMoreAdapter(private val dataList: List<String>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    // 普通布局
    private val TYPE_ITEM = 1
    // 脚布局
    private val TYPE_FOOTER = 2
    // 当前加载状态，默认为加载完成
    private var loadState = 2
    // 正在加载
    val LOADING = 1
    // 加载完成
    val LOADING_COMPLETE = 2
    // 加载到底
    val LOADING_END = 3

    override fun getItemViewType(position: Int): Int =
            if (position + 1 == itemCount) {
                TYPE_FOOTER
            } else {
                TYPE_ITEM
            }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder? {
        // 通过判断显示类型，来创建不同的View
        if (viewType == TYPE_ITEM) {
            val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_refresh_rlv, parent, false)
            return RecyclerViewHolder(view)

        } else if (viewType == TYPE_FOOTER) {
            val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.layout_refresh_footer, parent, false)
            return FootViewHolder(view)
        }
        return null
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is RecyclerViewHolder) {
            holder.tvItem.text = dataList[position]

        } else if (holder is FootViewHolder) {
            when (loadState) {
                LOADING // 正在加载
                -> {
                    holder.pbLoading.visibility = View.VISIBLE
                    holder.tvLoading.visibility = View.VISIBLE
                    holder.llEnd.visibility = View.GONE
                }

                LOADING_COMPLETE // 加载完成
                -> {
                    holder.pbLoading.visibility = View.INVISIBLE
                    holder.tvLoading.visibility = View.INVISIBLE
                    holder.llEnd.visibility = View.GONE
                }

                LOADING_END // 加载到底
                -> {
                    holder.pbLoading.visibility = View.GONE
                    holder.tvLoading.visibility = View.GONE
                    holder.llEnd.visibility = View.VISIBLE
                }

                else -> {
                }
            }
        }
    }

    override fun getItemCount(): Int {
        return dataList.size + 1
    }

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView?) {
        super.onAttachedToRecyclerView(recyclerView)
        val manager = recyclerView!!.layoutManager
        if (manager is GridLayoutManager) {
            manager.spanSizeLookup = object : GridLayoutManager.SpanSizeLookup() {
                override fun getSpanSize(position: Int): Int {
                    // 如果当前是footer的位置，那么该item占据2个单元格，正常情况下占据1个单元格
                    return if (getItemViewType(position) == TYPE_FOOTER) manager.spanCount else 1
                }
            }
        }
    }

    private inner class RecyclerViewHolder internal constructor(itemView: View) : RecyclerView.ViewHolder(itemView) {

        internal var tvItem: TextView

        init {
            tvItem = itemView.findViewById(R.id.tv_item) as TextView
        }
    }

    private inner class FootViewHolder internal constructor(itemView: View) : RecyclerView.ViewHolder(itemView) {

        internal var pbLoading: ProgressBar
        internal var tvLoading: TextView
        internal var llEnd: LinearLayout

        init {
            pbLoading = itemView.findViewById(R.id.pb_loading) as ProgressBar
            tvLoading = itemView.findViewById(R.id.tv_loading) as TextView
            llEnd = itemView.findViewById(R.id.ll_end) as LinearLayout
        }
    }

    /**
     * 设置上拉加载状态
     *
     * @param loadState 0.正在加载 1.加载完成 2.加载到底
     */
    fun setLoadState(loadState: Int) {
        this.loadState = loadState
        notifyDataSetChanged()
    }
}
