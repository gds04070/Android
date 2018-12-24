package concertrip.sopt.com.concertrip.activities.main.fragment.calendar.viewholder

import android.view.View
import android.widget.TextView
import concertrip.sopt.com.concertrip.R
import kotlinx.android.synthetic.main.item_calendar.view.*
import kotlin.properties.Delegates

class CalendarViewHolder(var itemView : View) {
     var  tvDate : TextView? = itemView.findViewById<TextView>(R.id.tv_calendar_date)
     var  tvDay : TextView? = itemView.findViewById<TextView>(R.id.tv_calendar_day)
}