package concertrip.sopt.com.concertrip.list.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.URLUtil
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import concertrip.sopt.com.concertrip.R
import concertrip.sopt.com.concertrip.activities.info.ArtistActivity
import concertrip.sopt.com.concertrip.interfaces.BasicListViewHolder
import concertrip.sopt.com.concertrip.interfaces.ListData
import concertrip.sopt.com.concertrip.list.viewholder.ArtistThumbViewHolder
import concertrip.sopt.com.concertrip.list.viewholder.ArtistViewHolder
import concertrip.sopt.com.concertrip.list.viewholder.ConcertViewHolder
import org.jetbrains.anko.startActivity

class BasicListAdapter(var mContext : Context, var dataList: ArrayList<out ListData>,var type : Int) : RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    companion object {
        val TYPE_ARTIST = 0
        val TYPE_ARTIST_THUMB =1
        val TYPE_CONCERT=2
        val TYPE_ALARM=3


    }

    var onClickListener  : View.OnClickListener? = null


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        when(type){
            TYPE_ARTIST->{
                val view = LayoutInflater.from(mContext).inflate(R.layout.li_artist, parent, false)
                return ArtistViewHolder(view)
            }
            TYPE_ARTIST_THUMB->{
                val view = LayoutInflater.from(mContext).inflate(R.layout.li_artist_thumb, parent, false)
                return ArtistThumbViewHolder(view)
            }
            else ->{ //TYPE_CONCERT ->{
                val view = LayoutInflater.from(mContext).inflate(R.layout.li_concert, parent, false)
                return ConcertViewHolder(view)
            }
//            else->{
//                val view = LayoutInflater.from(mContext).inflate(R.layout.li_alarm, parent, false)
//                return AlarmViewHolder(view)
//            }
        }
    }

    override fun getItemCount(): Int = dataList.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {


        val basicHolder = holder as BasicListViewHolder
        basicHolder.getMainTitle().text=dataList[position].getMainTitle()
        basicHolder.getSubTitle()?.text=dataList[position].getSubTitle()
        if( URLUtil.isValidUrl(dataList[position].getImageUrl())){
            Glide.with(mContext).load(dataList[position].getImageUrl()).apply(RequestOptions.circleCropTransform())
                .into(holder.getIvIcon())
        }
        basicHolder.getBtn()?.setOnClickListener(onClickListener)

    }

}