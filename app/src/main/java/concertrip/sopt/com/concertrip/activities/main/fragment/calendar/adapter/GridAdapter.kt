package concertrip.sopt.com.concertrip.activities.main.fragment.calendar.adapter

import android.content.Context
import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import android.support.v4.content.ContextCompat
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import concertrip.sopt.com.concertrip.R
import concertrip.sopt.com.concertrip.activities.main.fragment.calendar.viewholder.CalendarViewHolder
import org.jetbrains.anko.layoutInflater
import android.support.v4.content.ContextCompat.getSystemService
import concertrip.sopt.com.concertrip.R.id.tv_month
import concertrip.sopt.com.concertrip.R.id.tv_year
import java.util.*
import kotlin.properties.Delegates
import java.nio.file.Files.size




/**

 * 그리드뷰 어댑터

 *

 */

class GridAdapter(var context : Context) : BaseAdapter() {

    private var mContext: Context by Delegates.notNull()

    var inflater: LayoutInflater by Delegates.notNull()
    private var mCal: Calendar by Delegates.notNull()

    var list: ArrayList<String> by Delegates.notNull()

    /**

     * 생성자

     *

     * @param context

     * @param list

     */

    constructor(context: Context, list: ArrayList<String>) : this(context) {

        mContext = context

        this.list = list
        this.inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    }

    override fun getItem(position: Int): Any = list[position]

    override fun getItemId(position: Int): Long =position.toLong()

    override fun getCount(): Int = list.size

    override fun getView(position: Int, view: View?, parent: ViewGroup?): View {

        var holder: CalendarViewHolder? = null;


        val convertView: View
        if (view == null) {

            convertView = inflater.inflate(R.layout.item_calendar, parent, false);

            holder = CalendarViewHolder()

            holder.tvItemGridView = convertView.findViewById(R.id.tv_days);

            convertView.tag = holder;

        } else {
            convertView = view
            holder = convertView.tag as CalendarViewHolder;

        }

        holder.tvItemGridView.text =  getItem(position).toString();


        //해당 날짜 텍스트 컬러,배경 변경

        mCal = Calendar.getInstance();

        //오늘 day 가져옴

        val today: Int = mCal.get(Calendar.DAY_OF_MONTH);

        val sToday: String = today.toString()

        if (sToday == getItem(position)) { //오늘 day 텍스트 컬러 변경
            holder.tvItemGridView.setTextColor(ContextCompat.getColor(mContext,R.color.primary_dark_material_light))

        }

        return convertView;
    }
}

