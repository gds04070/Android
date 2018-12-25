package concertrip.sopt.com.concertrip.activities.main.fragment.calendar

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import concertrip.sopt.com.concertrip.R
import concertrip.sopt.com.concertrip.activities.main.fragment.calendar.adapter.CalendarAdapter
import concertrip.sopt.com.concertrip.activities.main.interfaces.OnFragmentInteractionListener
import concertrip.sopt.com.concertrip.model.Artist
import concertrip.sopt.com.concertrip.model.Concert
import concertrip.sopt.com.concertrip.model.Schedule
import concertrip.sopt.com.concertrip.utillity.Constants
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

    private var gridAdapter : CalendarAdapter by Delegates.notNull();

    /*TODO
    * have to make interface which contains schedule list
    * + adapter
    * + hash map key=day value=interface()*/

   // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private var listener: OnFragmentInteractionListener? = null



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

        activity?.let {
            gridAdapter = CalendarAdapter(it,Schedule.toMap(Schedule.getDummyList()))

            gv_calendar.adapter = gridAdapter


        }
        initialUI()

    }

    private fun drawCalendar(){



    }


    // TODO: Rename method, update argument and hook method into UI event
    fun onButtonPressed(uri: Uri) {
        listener?.onFragmentInteraction(uri)
    }

    fun changeFragment(){
        listener?.changeFragment(Constants.FRAGMENT_NOTIFICATION)
    }


    private fun initialUI(){
        btn_notification.setOnClickListener {
            changeFragment()
        }
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
