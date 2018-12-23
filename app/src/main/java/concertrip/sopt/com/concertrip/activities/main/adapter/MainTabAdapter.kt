package concertrip.sopt.com.concertrip.activities.main.adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import concertrip.sopt.com.concertrip.activities.main.fragment.mypage.MyPageFragment
import concertrip.sopt.com.concertrip.activities.main.fragment.calendar.CalendarFragment
import concertrip.sopt.com.concertrip.activity.main.fragment.liked.LikedFragment
import concertrip.sopt.com.concertrip.activity.main.fragment.search.SearchFragment
import concertrip.sopt.com.concertrip.utillity.Constatns
import kotlin.properties.Delegates

/**
 * Created by lumiere on 2018-05-01.
 */
class MainTabAdapter(fm: FragmentManager?) : FragmentStatePagerAdapter(fm) {

    var tabCount: Int = 0
    var calendarFragment: CalendarFragment by Delegates.notNull()
    var likedFragment: LikedFragment by Delegates.notNull()
    var searchFragment: SearchFragment by Delegates.notNull()
    var mypageFragment: MyPageFragment by Delegates.notNull()


    constructor(fm: FragmentManager?, tabCount: Int) : this(fm) {
        this.tabCount = tabCount

        this.calendarFragment = CalendarFragment()
        this.likedFragment= LikedFragment()
        this.searchFragment = SearchFragment()
        this.mypageFragment = MyPageFragment()
    }


    override fun getItem(position: Int): Fragment? {
        return when (position) {
            Constatns.TAB_CALENDAR -> calendarFragment
            Constatns.TAB_SEARCH -> searchFragment
            Constatns.TAB_LIKED -> likedFragment
            Constatns.TAB_MY_PAGE->mypageFragment
            else -> null
        }

    }

    override fun getCount(): Int = tabCount
}
