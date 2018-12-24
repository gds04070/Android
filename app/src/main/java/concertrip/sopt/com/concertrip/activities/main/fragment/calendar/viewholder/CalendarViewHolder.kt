package concertrip.sopt.com.concertrip.activities.main.fragment.calendar.viewholder

import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import concertrip.sopt.com.concertrip.R
import kotlinx.android.synthetic.main.item_calendar.view.*
import org.jetbrains.anko.find
import kotlin.properties.Delegates

class CalendarViewHolder(var itemView : View) {
     var lySchedule : LinearLayout? = itemView.findViewById(R.id.ly_schedule)
     var  tvDate : TextView? = itemView.findViewById(R.id.tv_calendar_date)
     var  tvDay : TextView? = itemView.findViewById(R.id.tv_calendar_day)
}