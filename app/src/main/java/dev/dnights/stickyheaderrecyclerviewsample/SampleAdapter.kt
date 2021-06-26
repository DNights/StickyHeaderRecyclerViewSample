package dev.dnights.stickyheaderrecyclerviewsample

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class SampleAdapter : RecyclerView.Adapter<SampleAdapter.SampleViewHolder>() {

    val sampleList = arrayListOf<SampleData>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SampleViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.viewholder_sample, parent, false)
        return SampleViewHolder(view)
    }

    override fun onBindViewHolder(holder: SampleViewHolder, position: Int) {
        holder.bindView(sampleList[position])
    }

    override fun getItemCount(): Int {
        return sampleList.size
    }

    inner class SampleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvContents = itemView.findViewById<TextView>(R.id.tvContents)

        fun bindView(data: SampleData) {
            tvContents.text = data.stringData
        }
    }
}

