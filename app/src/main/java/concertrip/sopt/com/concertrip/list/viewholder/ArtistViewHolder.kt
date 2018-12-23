package concertrip.sopt.com.concertrip.list.viewholder

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.Button
import android.widget.TextView
import concertrip.sopt.com.concertrip.R

class ArtistViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val tvArtist : TextView = itemView.findViewById(R.id.tv_artist)
    val tvTag : TextView = itemView.findViewById(R.id.tv_artist_tag)
    val btnFollow : Button = itemView.findViewById(R.id.btn_follow)
}