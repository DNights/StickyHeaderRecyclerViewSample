package dev.dnights.stickyheaderrecyclerviewsample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private val sampleAdapter = SampleAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rvMain = findViewById<RecyclerView>(R.id.rvMain)
        rvMain.adapter = sampleAdapter
        rvMain.layoutManager = LinearLayoutManager(this)
        val sectionItemDecoration = StickyHeaderItemDecoration(getSectionCallback())
        rvMain.addItemDecoration(sectionItemDecoration)

        initSampleList()
    }

    private fun getSectionCallback(): StickyHeaderItemDecoration.SectionCallback {
        return object : StickyHeaderItemDecoration.SectionCallback {
            override fun isHeader(position: Int): Boolean {
                return sampleAdapter.isHeader(position)
            }

            override fun getHeaderLayoutView(list: RecyclerView, position: Int): View? {
                return sampleAdapter.getHeaderView(list, position)
            }
        }
    }

    private fun initSampleList() {
        sampleAdapter.sampleList.add(SampleData("header"))
        sampleAdapter.sampleList.add(SampleData("top holder"))
        for (i in 0..50) {
            sampleAdapter.sampleList.add(SampleData("sample[$i]"))
        }
        sampleAdapter.sampleList.add(SampleData("bottom"))

        sampleAdapter.notifyDataSetChanged()
    }
}