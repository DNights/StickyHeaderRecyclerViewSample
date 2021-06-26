package dev.dnights.stickyheaderrecyclerviewsample

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class SampleAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    val sampleList = arrayListOf<SampleData>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when(viewType) {
            TYPE_HEADER -> {
                val view = LayoutInflater.from(parent.context).inflate(R.layout.viewholder_header, parent, false)
                HeaderViewHolder(view)
            }
            TYPE_TOP_HOLDER -> {
                val view = LayoutInflater.from(parent.context).inflate(R.layout.viewholder_top_holder, parent, false)
                TopHolderViewHolder(view)
            }
            TYPE_BOTTOM -> {
                val view = LayoutInflater.from(parent.context).inflate(R.layout.viewholder_bottom, parent, false)
                BottomViewHolder(view)
            }
            TYPE_ITEM -> {
                val view = LayoutInflater.from(parent.context).inflate(R.layout.viewholder_sample, parent, false)
                SampleViewHolder(view)
            }
            else -> TODO("unknow viewtype : $viewType")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is HeaderViewHolder -> holder.bindView()
            is TopHolderViewHolder -> holder.bindView()
            is BottomViewHolder -> holder.bindView()
            is SampleViewHolder ->  holder.bindView(sampleList[position])
        }
    }

    override fun getItemCount(): Int {
        return sampleList.size
    }

    override fun getItemViewType(position: Int) = when (position) {
        0 -> TYPE_HEADER
        1 -> TYPE_TOP_HOLDER
        sampleList.size-1 -> TYPE_BOTTOM
        else -> TYPE_ITEM

    }

    companion object {
        const val TYPE_HEADER = 0
        const val TYPE_TOP_HOLDER = 1
        const val TYPE_BOTTOM = 2
        const val TYPE_ITEM = 3
    }

    inner class HeaderViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindView() {}
    }

    inner class TopHolderViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindView() {}
    }

    inner class BottomViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindView() {}
    }

    inner class SampleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvContents = itemView.findViewById<TextView>(R.id.tvContents)

        fun bindView(data: SampleData) {
            tvContents.text = data.stringData
        }
    }
}

