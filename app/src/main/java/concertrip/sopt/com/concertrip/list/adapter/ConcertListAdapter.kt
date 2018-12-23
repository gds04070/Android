package concertrip.sopt.com.concertrip.list.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import concertrip.sopt.com.concertrip.R
import concertrip.sopt.com.concertrip.list.viewholder.ConcertViewHolder
import concertrip.sopt.com.concertrip.list.viewholder.TicketViewHolder
import concertrip.sopt.com.concertrip.model.Concert
import org.jetbrains.anko.image

class ConcertListAdapter(var mContext: Context, var dataList: ArrayList<Concert>) : RecyclerView.Adapter<ConcertViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ConcertViewHolder {
        val mainView: View = LayoutInflater.from(mContext).inflate(R.layout.li_concert, parent, false)
        return ConcertViewHolder(mainView)
    }

    override fun getItemCount(): Int = dataList.size

    override fun getItemViewType(position: Int): Int = position

    override fun onBindViewHolder(holder: ConcertViewHolder, position: Int) {

            val concert= dataList[position]
            holder.tvTag.text = concert.getTag()
            holder.tvname.text = concert.title

            holder.ivLike.setOnClickListener {

            }
    }
}