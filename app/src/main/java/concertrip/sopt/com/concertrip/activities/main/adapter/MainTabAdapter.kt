package concertrip.sopt.com.concertrip.activities.main.adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import concertrip.sopt.com.concertrip.activities.main.fragment.mypage.MyPageFragment
import concertrip.sopt.com.concertrip.activities.main.fragment.calendar.CalendarFragment
import concertrip.sopt.com.concertrip.activity.main.fragment.liked.LikedFragment
import concertrip.sopt.com.concertrip.activity.main.fragment.search.SearchResultFragment
import concertrip.sopt.com.concertrip.utillity.Constants
import kotlin.properties.Delegates

/**
 * Created by lumiere on 2018-05-01.
 */
class MainTabAdapter(fm: FragmentManager?) : FragmentStatePagerAdapter(fm) {

    var tabCount: Int = 0
    var calendarFragment: CalendarFragment by Delegates.notNull()
    var likedFragment: LikedFragment by Delegates.notNull()
    var searchFragment: SearchResultFragment by Delegates.notNull()
    var mypageFragment: MyPageFragment by Delegates.notNull()


    constructor(fm: FragmentManager?, tabCount: Int) : this(fm) {
        this.tabCount = tabCount

        this.calendarFragment = CalendarFragment()
        this.likedFragment= LikedFragment()
        this.searchFragment = SearchResultFragment()
        this.mypageFragment = MyPageFragment()
    }


    override fun getItem(position: Int): Fragment? {
        return when (position) {
            Constants.TAB_CALENDAR -> calendarFragment
            Constants.TAB_SEARCH -> searchFragment
            Constants.TAB_LIKED -> likedFragment
            Constants.TAB_MY_PAGE->mypageFragment
            else -> null
        }

    }

    override fun getCount(): Int = tabCount
}
