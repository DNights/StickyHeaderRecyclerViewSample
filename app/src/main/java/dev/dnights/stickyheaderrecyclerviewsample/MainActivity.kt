package dev.dnights.stickyheaderrecyclerviewsample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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

        sampleAdapter.sampleList.add(SampleData("header"))
        sampleAdapter.sampleList.add(SampleData("top holder"))
        for (i in 0..50){
            sampleAdapter.sampleList.add(SampleData("sample[$i]"))
        }
        sampleAdapter.sampleList.add(SampleData("bottom"))

        sampleAdapter.notifyDataSetChanged()
    }


}