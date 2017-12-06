package cn.suiseiseki.www.ravenland.extensions

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * Created by shui_keyi on 2017/12/6.
 * Email:shuikeyi92@gmail.com
 */
fun ViewGroup.inflate(layoutid : Int, attached : Boolean = false) : View
{
    return LayoutInflater.from(context).inflate(layoutid,this,attached)
}