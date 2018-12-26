package concertrip.sopt.com.concertrip.activities.info

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity;
import android.view.View
import com.google.android.youtube.player.internal.v
import concertrip.sopt.com.concertrip.R
import concertrip.sopt.com.concertrip.list.adapter.BasicListAdapter
import concertrip.sopt.com.concertrip.model.Artist
import concertrip.sopt.com.concertrip.model.Concert

import kotlinx.android.synthetic.main.content_concert.*

class ConcertActivity : AppCompatActivity(){

    var concert : Concert = Concert()
    var dataList = arrayListOf<Artist>() // 이것도 서버에서 한번에 concert에 넣어서 전달해줄지도 모름!!
    // 현재 concert 클래스에 포함되어 있는 변수들은 정확하지 않음
    // ex. 티켓링크가 포함되어 있지 않음
    // >> 디비 완전히 나오면 나중에 더 추가하거나 제거할 예정

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_concert)
//        setSupportActionBar(toolbar)

//        val mAdapter = ArtistThumbListAdapter(this, Artist.getDummyArray())
        val mAdapter = BasicListAdapter(this, Artist.getDummyArray())
        recycler_view.adapter = mAdapter

    }

}
