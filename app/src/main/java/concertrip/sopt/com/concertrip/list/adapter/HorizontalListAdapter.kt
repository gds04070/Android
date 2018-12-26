package concertrip.sopt.com.concertrip.list.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import concertrip.sopt.com.concertrip.R
import concertrip.sopt.com.concertrip.list.viewholder.HorizontalVIewHolder


class HorizontalListAdapter(val mContext : Context, var dataList: ArrayList<String>) : RecyclerView.Adapter<HorizontalVIewHolder>(){




    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HorizontalVIewHolder {
        val view : View = LayoutInflater.from(mContext).inflate(R.layout.li_tag, parent, false)
        return HorizontalVIewHolder(view)

    }

    override fun getItemCount(): Int = dataList.size

    override fun onBindViewHolder(holder: HorizontalVIewHolder, position: Int) {
       holder.tvtext.text = dataList[position]
    }
}