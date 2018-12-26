package concertrip.sopt.com.concertrip.activities.info

import android.os.Bundle
import android.support.v7.app.AppCompatActivity;
import android.view.View
import concertrip.sopt.com.concertrip.R
import concertrip.sopt.com.concertrip.list.adapter.BasicListAdapter
import concertrip.sopt.com.concertrip.model.Artist
import concertrip.sopt.com.concertrip.model.Concert

import kotlinx.android.synthetic.main.content_artist.*
import org.jetbrains.anko.startActivity

class ArtistActivity : AppCompatActivity() {

    var artist : Artist = Artist()
    var dataList = arrayListOf<Concert>() // 뭔가 서버에서 artist에 넣어서 한번에 전달해 줄듯

    var onListItemClickListener : View.OnClickListener = View.OnClickListener {
        startActivity<ConcertActivity>()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_artist)
//        setSupportActionBar(toolbar)

//        val mAdapter = ConcertListAdapter(this, Concert.getDummyArray())
        val mAdapter = BasicListAdapter(this, Concert.getDummyArray())
        mAdapter.onClickListener=onListItemClickListener
        recycler_view.adapter = mAdapter

    }

    companion object {
        fun newInstance(): ArtistActivity = ArtistActivity()
    }
}
