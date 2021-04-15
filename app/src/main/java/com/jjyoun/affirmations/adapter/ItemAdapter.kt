package com.jjyoun.affirmations.adapter

import android.content.ClipData
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.jjyoun.affirmations.R
import com.jjyoun.affirmations.model.Affirmation

/*
* Adapter for the [RecyclerView] in [MainActivity]. Displays [Affirmation] data object.
* */
class ItemAdapter(
    private val context: Context,
    private val dataset: List<Affirmation>
) : RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {

    //RecyclerView는 item views와 직접 상호작용하지 않는 대신 ViewHolders를 처리한다..
    //RecyclerView가 화면에서 뷰를 효율적으로 움직이는데 사용하는 추가적인 정보도 추가한다.
    //새 데이터로 list item view를 업데이트 하기 쉬워진다..
    /*
    * Provide a reference to the views for each data item
    * 각 데이터 아이템애 대한 뷰의 reference를 제공한다.
    * Complex data items may need more than one view per item, and
    * you provide access to all the views for a data item in a view holder.
    * 복합 데이터 아이템은 아이템 당 하나 이상의 뷰를 필요로하고
    * 뷰 홀더에서 데이터 아이템에 대한 모든 뷰에 접근할 수 있다.
    * Each data item is just an Affirmation object.
    * 각 데이터 아이템은 Affirmation 객체이다.
    *
    * */
    class ItemViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView = view.findViewById(R.id.item_title)
        val imageViewHolder: ImageView = view.findViewById(R.id.item_image)
    }

    /*
    * Create new views(invoked by the layout manager)
    * 레이아웃매니저에 의해 유도된 뷰를 생성
    * */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        //create a new view
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item, parent, false)
        return ItemViewHolder(adapterLayout)
    }

    /*
    * Replace the contents of a view (invoked by the layout manager)
    * 레이아웃 매니저에 의해 유도된 뷰의 내용을 대체함
    * */
    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = dataset[position]
        //string Resource ID를 전달.. 결과 string은 ItemViewHolder 내 textview의 text로 set 된다.
        holder.textView.text = context.resources.getString(item.stringResourceId)
        holder.imageViewHolder.setImageResource(item.imageResourceId)
    }

    /*
    * Return the size of your dataset (invoked by the layout manager)
    * 레이아웃 매니저에 의해 유도된 데이터셋의 사이즈를 반환
    * */
    override fun getItemCount() = dataset.size

}