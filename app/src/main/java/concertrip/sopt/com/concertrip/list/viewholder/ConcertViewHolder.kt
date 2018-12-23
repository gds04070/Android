package concertrip.sopt.com.concertrip.list.viewholder

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import concertrip.sopt.com.concertrip.R

class ConcertViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView) {

    val ivconcert: ImageView = itemView.findViewById(R.id.iv_concert) as ImageView
    val tvname : TextView = itemView.findViewById(R.id.tv_concert) as TextView
    val tvTag : TextView = itemView.findViewById(R.id.tv_concert_tag) as TextView
    val ivLike : ImageButton = itemView.findViewById(R.id.btn_like) as ImageButton
}