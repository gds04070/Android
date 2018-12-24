package concertrip.sopt.com.concertrip.list.adapter

import android.content.Context
import android.graphics.drawable.Drawable
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions;
import concertrip.sopt.com.concertrip.R
import concertrip.sopt.com.concertrip.R.id.parent
import concertrip.sopt.com.concertrip.list.viewholder.ArtistThumbViewHolder
import concertrip.sopt.com.concertrip.list.viewholder.TicketViewHolder
import concertrip.sopt.com.concertrip.model.Artist
import android.util.Log
import android.view.View
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target

class ArtistThumbListAdapter(var mContext : Context, var dataList: ArrayList<Artist>) : RecyclerView.Adapter<ArtistThumbViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, position: Int): ArtistThumbViewHolder {
        val view = LayoutInflater.from(mContext).inflate(R.layout.li_artist_thumb, parent, false)
        return ArtistThumbViewHolder(view)
    }

    override fun getItemCount(): Int = dataList!!.size

    override fun onBindViewHolder(holder: ArtistThumbViewHolder, position: Int) {
        //Glide.with(mContext).load(dataList[position].profileImg).apply(RequestOptions.circleCropTransform()).into(holder!!.ivArtist)
        Glide.with(mContext).load(dataList[position].profileImg).listener(object : RequestListener<Drawable> {
            override fun onLoadFailed(
                e: GlideException?,
                model: Any?,
                target: Target<Drawable>?,
                isFirstResource: Boolean
            ): Boolean {
                return true
            }

            override fun onResourceReady(
                resource: Drawable?,
                model: Any?,
                target: Target<Drawable>?,
                dataSource: DataSource?,
                isFirstResource: Boolean
            ): Boolean {
                return false
            }

        }).apply(RequestOptions().fitCenter()).into(holder.ivArtist)
        Log.d("1223", "posiiton : "+ dataList.get(position) + dataList!!.get(position).profileImg) //.apply(RequestOptions.circleCropTransform())
        holder!!.tvArtist.setText(dataList!!.get(position).name)
        holder.ivArtist.setOnClickListener{
            /*TODO
            * 클릭시 해당 아티스트의 디테일 뷰로 이동*/
        }
    }
}