package com.sumavision.www.sumalab.ui

import android.os.Bundle

/**
 * Created by shui_keyi on 2017/12/5.
 * Email:shuikeyi92@gmail.com
 * 定义Fragment和Activity的共同行为
 */
interface UiAction {
    //用于Fragment/Activity数据的初始化
    fun initData(savedInstanceState : Bundle?)

    // 用于设置监听器
    fun setListener()

    // 获取布局ID
    fun getLayoutId() : Int

}