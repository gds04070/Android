package concertrip.sopt.com.concertrip.list.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import concertrip.sopt.com.concertrip.R
import concertrip.sopt.com.concertrip.list.viewholder.AlarmViewHolder
import concertrip.sopt.com.concertrip.model.Alarm


class AlarmListAdapter(var mContext: Context, var dataList : ArrayList<Alarm>) : RecyclerView.Adapter<AlarmViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlarmViewHolder {
        var view : View = LayoutInflater.from(mContext).inflate(R.layout.li_alarm, parent, false )
        return AlarmViewHolder(view)
    }

    override fun getItemCount(): Int = dataList.size

    override fun onBindViewHolder(holder: AlarmViewHolder, position: Int) {

    }
}