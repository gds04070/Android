package concertrip.sopt.com.concertrip.activities.main.fragment.calendar

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import concertrip.sopt.com.concertrip.R
import concertrip.sopt.com.concertrip.activities.main.fragment.calendar.adapter.GridAdapter
import concertrip.sopt.com.concertrip.activities.main.interfaces.OnFragmentInteractionListener
import concertrip.sopt.com.concertrip.model.Artist
import concertrip.sopt.com.concertrip.model.Concert
import java.util.*
import kotlin.properties.Delegates
import kotlinx.android.synthetic.main.fragment_calendar.*
import java.text.SimpleDateFormat


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [CalendarFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [CalendarFragment.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class CalendarFragment : Fragment() {

    var dataListFilter = arrayListOf<String>()
    var dataListArtist = arrayListOf<Artist>()
    var dataListConcert = arrayListOf<Concert>()
    var dataListDay = arrayListOf<String>()

    // 날짜 > date객체(스트링으로 넘어옴)

    /*TODO
    * have to make interface which contains schedule list
    * + adapter
    * + hash map key=day value=interface()*/

   // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private var listener: OnFragmentInteractionListener? = null



    private var dayList = ArrayList<String>()
    private var gridAdapter : GridAdapter by Delegates.notNull();

    private var mCal: Calendar by Delegates.notNull()



    fun artistToCal(artist: Artist){
        /*TODO have to implement it*/
    }

    fun concertToCal(concert: Concert){
        /*TODO have to implement it*/
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_calendar, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        drawCalendar()
    }

    fun drawCalendar(){


        val now = System.currentTimeMillis()

        val date = Date(now)

        //연,월,일을 따로 저장

        val curYearFormat = SimpleDateFormat("yyyy", Locale.KOREA)

        val curMonthFormat = SimpleDateFormat("MM", Locale.KOREA)

        val curDayFormat = SimpleDateFormat("dd", Locale.KOREA)


        tv_year.text  = curYearFormat.format(date)
        tv_month.text=curMonthFormat.format(date)




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



        activity?.let {
            gridAdapter = GridAdapter(it.applicationContext, dayList)
            gv_calendar.adapter = gridAdapter

        }





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


    // TODO: Rename method, update argument and hook method into UI event
    fun onButtonPressed(uri: Uri) {
        listener?.onFragmentInteraction(uri)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnFragmentInteractionListener) {
            listener = context
        } else {
            throw RuntimeException(context.toString() + " must implement OnFragmentInteractionListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }


    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment CalendarFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            CalendarFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}
