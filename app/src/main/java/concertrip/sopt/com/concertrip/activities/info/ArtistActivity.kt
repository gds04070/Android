package concertrip.sopt.com.concertrip.activities.info

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity;
import com.google.android.youtube.player.YouTubeBaseActivity
import concertrip.sopt.com.concertrip.R
import concertrip.sopt.com.concertrip.model.Artist
import concertrip.sopt.com.concertrip.model.Concert

import kotlinx.android.synthetic.main.activity_artist.*

class ArtistActivity : AppCompatActivity() {

    var artist : Artist = Artist()
    var dataList = arrayListOf<Concert>() // 뭔가 서버에서 artist에 넣어서 한번에 전달해 줄듯

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_artist)
//        setSupportActionBar(toolbar)


    }

}
