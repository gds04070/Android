package concertrip.sopt.com.concertrip.activity.main.fragment.search

import android.content.Context
import android.os.Bundle
import android.os.Handler
import android.os.Message
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import concertrip.sopt.com.concertrip.R
import concertrip.sopt.com.concertrip.activities.info.ArtistActivity
import concertrip.sopt.com.concertrip.activities.main.fragment.search.SearchFragment
import concertrip.sopt.com.concertrip.interfaces.BasicListViewHolder
import concertrip.sopt.com.concertrip.interfaces.ListData
import concertrip.sopt.com.concertrip.interfaces.OnFragmentInteractionListener
import concertrip.sopt.com.concertrip.list.adapter.BasicListAdapter
import concertrip.sopt.com.concertrip.model.Artist
import concertrip.sopt.com.concertrip.model.Concert
import concertrip.sopt.com.concertrip.utillity.Constants
import kotlinx.android.synthetic.main.fragment_explorer.*
import org.jetbrains.anko.support.v4.startActivity
import java.lang.ref.WeakReference

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [SearchFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [SearchFragment.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class ExplorerFragment : Fragment() {

    var dataListArtist = arrayListOf<Artist>()
    var dataListConcert = arrayListOf<Concert>()

    var onItemClickListener : View.OnClickListener = View.OnClickListener {
        startActivity<ArtistActivity>()
    }


    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private var listener: OnFragmentInteractionListener? = null

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
        return inflater.inflate(R.layout.fragment_explorer, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialUI()
        connectRequestTag()
    }

    fun connectRequestTag(){
        //TODO Retrofit2
        //OnFaill -> Toast ,  OnSuccess-> connectRequest(),updateTagList()
    }

    fun connectRequestData(){
        //TODO onFail -> Toast, OnSuccess->uodateDataList()
    }
    fun updateTagList(dataList : ArrayList<out ListData>){
        //TODO 1.adapter의 dataList값을 Foreach이용 업데이트
        //혹은 dataList통째로 바꾸기


        //TODO 2. notifyAdapter

    }

    fun updateDataList(dataList : ArrayList<out ListData>){
        //TODO 1.adapter의 dataList값을 Foreach이용 업데이트
        //혹은 dataList통째로 바꾸기

        val adapter = BasicListAdapter(activity!!.applicationContext, dataListArtist, BasicListAdapter.TYPE_ARTIST)
        adapter.handler = HandlerClick(this)

        //TODO 2. adapter에 Listener 추가


        //TODO 3. notifyAdapter

    }


    fun changeFragment(){
        listener?.changeFragment(Constants.FRAGMENT_SEARCH_RESULT)
    }

    fun buttonClick(idx : Int){
        //TODO startActivity with index
    }

    private fun initialUI(){
        //TODO 검색버튼 눌렀을 경우 세팅


        //이거는 지워질 경우
        btn_more_station.setOnClickListener {
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



    private class HandlerClick(fragment: Fragment) : Handler() {
        private val mFragment: WeakReference<Fragment> = WeakReference<Fragment>(fragment)

        override fun handleMessage(msg: Message) {
            val f = mFragment.get() as ExplorerFragment

            f.buttonClick(msg.what)
        }
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment SearchFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ExplorerFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}