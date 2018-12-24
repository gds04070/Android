package concertrip.sopt.com.concertrip.activities.main.fragment.calendar.adapter

import android.app.Activity
import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import concertrip.sopt.com.concertrip.R
import concertrip.sopt.com.concertrip.activities.main.fragment.calendar.viewholder.CalendarViewHolder
import concertrip.sopt.com.concertrip.model.Schedule
import kotlinx.android.synthetic.main.fragment_calendar.*
import kotlinx.android.synthetic.main.item_schedule.view.*
import org.jetbrains.anko.db.INTEGER
import java.lang.ref.WeakReference
import java.util.*
import kotlin.properties.Delegates
import java.text.SimpleDateFormat
import kotlin.collections.ArrayList
import kotlin.collections.HashMap


/**

 * 그리드뷰 어댑터

 *

 */

class CalendarAdapter(var activity : Activity,var schedules : HashMap<Int,ArrayList<Schedule>>) : BaseAdapter() {
    private val mActivity: WeakReference<Activity> = WeakReference<Activity>(activity)

    private var dayList = ArrayList<String>()

    private var inflater: LayoutInflater by Delegates.notNull()
    private var mCal: Calendar by Delegates.notNull()

    private val viewHolderList = arrayOfNulls<CalendarViewHolder>(50)


    /**
     * 생성자
     *
     * @param activity
     */

    init{

        val mContext = activity.applicationContext
        this.inflater = mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

        val now = System.currentTimeMillis()

        val date = Date(now)

        //연,월,일을 따로 저장

        val curYearFormat = SimpleDateFormat("yyyy", Locale.KOREA)

        val curMonthFormat = SimpleDateFormat("MM", Locale.KOREA)

        val curDayFormat = SimpleDateFormat("dd", Locale.KOREA)



        mActivity.get()?.apply {
            tv_year.text  = curYearFormat.format(date)
            tv_month.text=curMonthFormat.format(date)
        }




        //gridview 요일 표시

        dayList = ArrayList()

        dayList.add("일")
        dayList.add("월")
        dayList.add("화")
        dayList.add("수")
        dayList.add("목")
        dayList.add("금")
        dayList.add("토")

        mCal = Calendar.getInstance()


        //이번달 1일 무슨요일인지 판단 mCal.set(Year,Month,Day)

        mCal.set(Integer.parseInt(curYearFormat.format(date)), Integer.parseInt(curMonthFormat.format(date)) - 1, 1)

        val dayNum = mCal.get(Calendar.DAY_OF_WEEK)

        //1일 - 요일 매칭 시키기 위해 공백 add

        for (i in 1 until dayNum) {
            dayList.add("")
        }

        setCalendarDate(mCal.get(Calendar.MONTH) + 1)





    }

    override fun getItem(position: Int): Any = dayList[position]

    override fun getItemId(position: Int): Long =position.toLong()

    override fun getCount(): Int = dayList.size

    override fun getView(position: Int, view: View?, parent: ViewGroup?): View {

        val holder: CalendarViewHolder?;


        val convertView: View
        if (view == null) {


            val date =dayList[position].toIntOrNull()?:-1

            convertView = if( date >0 || dayList[position].isBlank()) inflater.inflate(R.layout.item_calendar, parent, false)
            else  inflater.inflate(R.layout.item_calendar_day, parent, false)
            holder = CalendarViewHolder(convertView)
            viewHolderList[position]=holder


            if( schedules.containsKey(date)){
                schedules[date]?.forEach {
                    addSchedule(holder,it)
                }


            }
            if(date>0) {
                convertView.setOnClickListener {
                    addSchedule(holder, Schedule.getDummy())

                }
            }
            convertView.tag = holder

        } else {
            convertView = view
            holder = convertView.tag as CalendarViewHolder;

        }


        if(dayList[position].toIntOrNull() is Int)
            holder.tvDate?.text =  getItem(position).toString();
        else
            holder.tvDay?.text =  getItem(position).toString();


        //해당 날짜 텍스트 컬러,배경 변경

        mCal = Calendar.getInstance();

        //오늘 day 가져옴

        val today: Int = mCal.get(Calendar.DAY_OF_MONTH);

        val sToday: String = today.toString()


        if (sToday == getItem(position)) { //오늘 date 텍스트 컬러 변경

            holder.tvDate?.setTextColor(Color.WHITE)
            holder.itemView.setBackgroundColor(Color.RED)
        }

        return convertView;
    }


    /**

     * 해당 월에 표시할 일 수 구함

     *

     * @param month

     */

    private fun setCalendarDate(month : Int) {
        mCal.set(Calendar.MONTH, month - 1);
        for ( i  in 0 until mCal.getActualMaximum(Calendar.DAY_OF_MONTH)) {
            dayList.add("" + (i + 1));
        }
    }


    private fun addSchedule(holder: CalendarViewHolder,schedule: Schedule){
        val scheduleView =inflater.inflate(R.layout.item_schedule, null, false)
        scheduleView.tv_calendar_schedule.text=(schedule.text)
//                voteExamples.add(edtView.findViewById(R.id.edt_vote_example))
        holder.lySchedule?.addView(scheduleView)

    }

}

