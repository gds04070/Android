package concertrip.sopt.com.concertrip.activity.main

import android.net.Uri
import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity;
import android.view.Menu
import android.view.MenuItem
import concertrip.sopt.com.concertrip.R
import concertrip.sopt.com.concertrip.activities.main.adapter.MainTabAdapter
import concertrip.sopt.com.concertrip.activities.main.interfaces.OnFragmentInteractionListener
import concertrip.sopt.com.concertrip.utillity.Constatns

import kotlinx.android.synthetic.main.activity_main.*
import kotlin.properties.Delegates

class MainActivity : AppCompatActivity() , OnFragmentInteractionListener {
    override fun onFragmentInteraction(uri: Uri) {

        //Fragment에서 발생한 이벤트를 MainActivity에서 처리해야 할 일이 있을때!
    }


    var tabAdapter : MainTabAdapter by Delegates.notNull()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        setSupportActionBar(toolbar)


        main_tab.addTab(main_tab.newTab().setIcon(R.drawable.ic_tab).setText("캘린더"))
        main_tab.addTab(main_tab.newTab().setIcon(R.drawable.ic_tab).setText("탐색"))
        main_tab.addTab(main_tab.newTab().setIcon(R.drawable.ic_tab).setText("찜목록"))
        main_tab.addTab(main_tab.newTab().setIcon(R.drawable.ic_tab).setText("마이페이지"))



        tabAdapter = MainTabAdapter(supportFragmentManager, main_tab.tabCount)

        viewPager.adapter = tabAdapter

        main_tab.addOnTabSelectedListener(TabLayout.ViewPagerOnTabSelectedListener(viewPager))
        viewPager.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(main_tab))
        viewPager.setCurrentItem(Constatns.TAB_CALENDAR,false)

        viewPager.addOnPageChangeListener(object  : ViewPager.OnPageChangeListener{
            override fun onPageScrollStateChanged(state: Int) {

            }

            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
            }

            override fun onPageSelected(position: Int) {
                when(position){
                    Constatns.TAB_CALENDAR->{
                        //캘린터가 선택 되었을 경우
                    }

                    Constatns.TAB_SEARCH->{
                        //검색이 선택 되었을 경우
                    }

                    Constatns.TAB_LIKED->{
                        //찜 목록이 선택 되었을 경우
                    }

                    Constatns.TAB_MY_PAGE->{
                        //마이페이지가 선택 되었을 경우
                    }
                }
            }

        })
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}
