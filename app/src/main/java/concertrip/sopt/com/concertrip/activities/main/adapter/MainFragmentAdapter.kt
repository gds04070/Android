package concertrip.sopt.com.concertrip.activities.main.adapter

import android.support.design.widget.TabLayout
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentTransaction
import android.util.Log
import android.widget.FrameLayout
import concertrip.sopt.com.concertrip.R
import concertrip.sopt.com.concertrip.activities.main.fragment.calendar.CalendarFragment
import concertrip.sopt.com.concertrip.activities.main.fragment.mypage.MyPageFragment
import concertrip.sopt.com.concertrip.activity.main.fragment.liked.LikedFragment
import concertrip.sopt.com.concertrip.activity.main.fragment.search.SearchFragment
import concertrip.sopt.com.concertrip.utillity.Constatns.Companion.FRAGMENT_CALENDAR
import concertrip.sopt.com.concertrip.utillity.Constatns.Companion.FRAGMENT_LIKED
import concertrip.sopt.com.concertrip.utillity.Constatns.Companion.FRAGMENT_MY_PAGE
import concertrip.sopt.com.concertrip.utillity.Constatns.Companion.FRAGMENT_SEARCH
import kotlin.properties.Delegates

class MainFragmentAdapter(val fragmentManager: FragmentManager, val mainTab: TabLayout) {
//    var fragment : Fragment by Delegates.notNull()
    //var fragmentTransaction : FragmentTransaction by Delegates.notNull()

    var curFragmentId : Int by Delegates.notNull()

    /*TODO have to edit its icons when we get the icons from design team*/

    val setIcons = arrayOf(
            R.drawable.ic_account_circle, R.drawable.ic_account_circle,
            R.drawable.ic_account_circle, R.drawable.ic_account_circle
    )
    val unsetIcons = arrayOf(
        R.drawable.ic_account_circle, R.drawable.ic_account_circle,
        R.drawable.ic_account_circle, R.drawable.ic_account_circle
    )

    val fragments = arrayOf(
        CalendarFragment(), SearchFragment(), LikedFragment(), MyPageFragment()
    )

    init {
        //fragment 초기화 해주기
        curFragmentId = FRAGMENT_CALENDAR

        var fragment = fragments[curFragmentId]
        var fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.add(R.id.container ,fragment)
        fragmentTransaction.commit()

        mainTab.getTabAt(curFragmentId)!!.setIcon(setIcons[curFragmentId])
    }

    fun setFragment(what : Int){
        mainTab.getTabAt(curFragmentId)!!.setIcon(unsetIcons[curFragmentId])
        curFragmentId = what
        Log.d("testingg", what.toString())
        mainTab.getTabAt(curFragmentId)!!.setIcon(setIcons[curFragmentId])

        var fragmentTransaction = fragmentManager.beginTransaction()
        var fragment = fragments[curFragmentId]
        //if(fragment.isAdded) return
        fragmentTransaction.replace(R.id.container ,fragment)
        fragmentTransaction.commit()
    }

}