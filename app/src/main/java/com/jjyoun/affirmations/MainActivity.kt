package com.jjyoun.affirmations

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.jjyoun.affirmations.adapter.ItemAdapter
import com.jjyoun.affirmations.data.Datasource

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main) //이게 자동으로 만들어진 XML을 객체화하는 inflate 동작이다

        //몇 개의 textview가 추가되었는지 알 수 있다..? 아까 연습함..
       // val textview: TextView = findViewById(R.id.textview)
       // textview.text = Datasource().loadAffirmations().size.toString()

        val myDataset = Datasource().loadAffirmations()
        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
        recyclerView.adapter = ItemAdapter(this, myDataset)

        //Use this setting to improve performance if you know that changes
        //in content do not change the layout size of the RecyclerView
        recyclerView.setHasFixedSize(true)


    }
}