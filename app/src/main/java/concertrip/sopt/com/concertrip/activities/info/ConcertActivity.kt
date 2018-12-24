package concertrip.sopt.com.concertrip.activities.info

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity;
import concertrip.sopt.com.concertrip.R
import concertrip.sopt.com.concertrip.list.adapter.ArtistThumbListAdapter
import concertrip.sopt.com.concertrip.model.Artist

import kotlinx.android.synthetic.main.content_concert.*

class ConcertActivity : AppCompatActivity() {

    //var dataList = arrayListOf<Artist>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_concert)
//        setSupportActionBar(toolbar)

        val mAdapter = ArtistThumbListAdapter(this, Artist.getDummyArray())
        recycler_view.adapter = mAdapter
    }

}
