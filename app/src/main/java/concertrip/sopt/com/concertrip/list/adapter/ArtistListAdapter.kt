package concertrip.sopt.com.concertrip.list.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import concertrip.sopt.com.concertrip.R
import concertrip.sopt.com.concertrip.activities.info.ArtistActivity
import concertrip.sopt.com.concertrip.list.viewholder.ArtistViewHolder
import concertrip.sopt.com.concertrip.model.Artist
import org.jetbrains.anko.startActivity

class ArtistListAdapter(var mContext : Context, var dataList: ArrayList<Artist>) : RecyclerView.Adapter<ArtistViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArtistViewHolder {

        val mainView: View = LayoutInflater.from(parent.context).inflate(R.layout.li_artist, parent, false)
        return ArtistViewHolder(mainView)
    }

    override fun getItemViewType(position: Int): Int =  position

    override fun getItemCount(): Int = dataList.size;

    override fun onBindViewHolder(holder: ArtistViewHolder, position: Int) {
        val artist = dataList[position]
        holder.tvArtist.text=artist.name
        holder.tvTag.text=artist.getTag()

        holder.btnFollow.setOnClickListener {

        }

        holder.itemView.setOnClickListener {
            mContext.startActivity<ArtistActivity>()
        }
    }

}