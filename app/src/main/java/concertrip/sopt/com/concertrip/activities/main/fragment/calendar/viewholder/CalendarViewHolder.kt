package concertrip.sopt.com.concertrip.activities.main.fragment.calendar.viewholder

import android.view.View
import android.widget.GridLayout
import android.widget.LinearLayout
import android.widget.TextView
import concertrip.sopt.com.concertrip.R
import kotlinx.android.synthetic.main.item_calendar.view.*
import org.jetbrains.anko.find
import kotlin.properties.Delegates

class CalendarViewHolder(var itemView : View) {
     var lySchedule : GridLayout? = itemView.findViewById(R.id.ly_schedule)
     var  tvCalendar : TextView = itemView.findViewById(R.id.tv_calendar)
     var  tvEllipsis : TextView? = itemView.findViewById(R.id.tv_ellipsis)
}