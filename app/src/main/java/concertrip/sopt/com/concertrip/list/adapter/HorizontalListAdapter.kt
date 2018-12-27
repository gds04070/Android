package concertrip.sopt.com.concertrip.list.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import concertrip.sopt.com.concertrip.R
import concertrip.sopt.com.concertrip.interfaces.OnHorizontalItemClick
import concertrip.sopt.com.concertrip.list.viewholder.HorizontalViewHolder


class HorizontalListAdapter(val mContext : Context, var dataList: ArrayList<String>, var listener: OnHorizontalItemClick) : RecyclerView.Adapter<HorizontalViewHolder>(){

    private val mCallback: OnHorizontalItemClick = listener

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HorizontalViewHolder {
        val view : View = LayoutInflater.from(mContext).inflate(R.layout.li_tag, parent, false)
        return HorizontalViewHolder(view)

    }

    override fun getItemCount(): Int = dataList.size

    override fun onBindViewHolder(holder: HorizontalViewHolder, position: Int) {
       holder.tvtext.text = dataList[position]

        holder.itemView.setOnClickListener {
            mCallback.onClick(holder.position);
        }
    }
}