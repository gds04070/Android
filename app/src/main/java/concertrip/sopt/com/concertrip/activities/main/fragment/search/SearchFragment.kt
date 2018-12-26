package concertrip.sopt.com.concertrip.activities.main.fragment.search

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import concertrip.sopt.com.concertrip.R
import concertrip.sopt.com.concertrip.interfaces.OnFragmentInteractionListener
import concertrip.sopt.com.concertrip.list.adapter.BasicListAdapter
import concertrip.sopt.com.concertrip.model.Artist
import concertrip.sopt.com.concertrip.model.Concert
import kotlinx.android.synthetic.main.fragment_search.*

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
class SearchFragment : Fragment() {

    var dataListArtist = arrayListOf<Artist>()
    var dataListConcert = arrayListOf<Concert>()

    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private var listener: OnFragmentInteractionListener? = null

    private var searchTxt : String=""


    lateinit var concertListAdapter: BasicListAdapter

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
        return inflater.inflate(R.layout.fragment_search, container, false)

    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialUI()


    }

    // TODO: Rename method, update argument and hook method into UI event
    fun onButtonPressed(uri: Uri) {
        listener?.onFragmentInteraction(uri)
    }
    fun initialUI(){
        //TODO btn 이벤트 추가. 검색 내용을 conncetRequestData()

        //TODO 추가요청하기 버튼 이벤트 구현  -> Toast만 띄우기!

    }
    fun connectRequestData(){
        //TODO updateListData()

    }
    fun updateUI(obj : Any){
        //TODO 1. obj의 결과가 아무것도 없는지 확인

        //없으면 visibility를 GONE, ~~~대한 결과가 없습니다. update해줘야함.

        //아니면 ↓
        updateListArtist()
        updateListConcert()
//      updateListTheme()
    }


    private fun updateListArtist(){
        activity?.let {
            val mAdapter = BasicListAdapter(it.applicationContext, Artist.getDummyArray(),BasicListAdapter.TYPE_ARTIST)
            ly_artist_list.adapter = mAdapter
        }
    }


    private fun updateListConcert(){

        activity?.let {

            concertListAdapter = BasicListAdapter(it.applicationContext, Concert.getDummyArray(),BasicListAdapter.TYPE_CONCERT)
            ly_concert_list.adapter = concertListAdapter

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
         * @return A new instance of fragment SearchResultFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            SearchFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}
