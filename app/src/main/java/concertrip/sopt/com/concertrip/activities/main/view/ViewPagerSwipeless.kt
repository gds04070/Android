package concertrip.sopt.com.concertrip.activities.main.view

import android.content.Context
import android.support.v4.view.ViewPager
import android.util.AttributeSet
import android.view.MotionEvent

class ViewPagerSwipeless(context: Context, attrs: AttributeSet) : ViewPager(context, attrs) {


    override fun onTouchEvent(event: MotionEvent): Boolean {
        return  false

    }

    override fun onInterceptTouchEvent(event: MotionEvent): Boolean {
        return false

    }

}