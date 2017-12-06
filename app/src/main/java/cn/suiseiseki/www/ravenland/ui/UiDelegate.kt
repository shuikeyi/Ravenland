package cn.suiseiseki.www.ravenland.ui

import android.view.View

/**
 * Created by shui_keyi on 2017/12/5.
 * Email:shuikeyi92@gmail.com
 * 用于接管UI的一些操作（一般为非UI操作)
 */
interface UiDelegate {
    fun resume()
    fun pause()
    fun stop()
    fun destroy()

    fun visible(view : View)
    {
        view.visibility = View.VISIBLE
    }

    fun invisible(view: View)
    {
        view.visibility = View.INVISIBLE
    }

    fun gone(view : View)
    {
        view.visibility = View.GONE
    }
}