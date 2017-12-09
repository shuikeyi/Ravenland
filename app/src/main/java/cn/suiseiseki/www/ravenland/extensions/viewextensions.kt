package cn.suiseiseki.www.ravenland.extensions

import android.content.Context
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast

/**
 * Created by shui_keyi on 2017/12/6.
 * Email:shuikeyi92@gmail.com
 */
//主线程及其Handler
val mainHandler = android.os.Handler(Looper.getMainLooper())

fun ViewGroup.inflate(layoutid : Int, attached : Boolean = false) : View
{
    return LayoutInflater.from(context).inflate(layoutid,this,attached)
}
fun View.gone() {
    this.visibility = View.GONE
}
fun View.visible()
{
    this.visibility = View.VISIBLE
}
fun View.invisible()
{
    this.visibility = View.INVISIBLE
}

fun makeToast(context : Context?, message : String)
{
    if(context != null)
        mainHandler.post { Toast.makeText(context,message, Toast.LENGTH_SHORT).show() }
}

//在一定延迟后消失
fun View.dispearInTime(time : Long)
{
    mainHandler.postDelayed({this.visibility = View.INVISIBLE},time)
}
// 显示一段时间后消失(0以下表示不消失)
fun View.appear(dispearTime : Long)
{
    if(dispearTime > 0L)
    {
        mainHandler.postDelayed({this.visibility = View.VISIBLE},0)
        this.dispearInTime(dispearTime)
    }
    //  forever young
    else
    {
        mainHandler.post{this.visibility = View.VISIBLE}
    }
}