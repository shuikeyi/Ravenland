package com.sumavision.www.sumalab.ui

import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity

/**
 * Created by shui_keyi on 2017/12/5.
 * Email:shuikeyi92@gmail.com
 */
abstract class BaseActivity : AppCompatActivity(),UiAction {

    open val uiDelegater by lazy {
        UiBaseDelegate(this)
    }

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContentView(getLayoutId())
        setListener()
        initData(savedInstanceState)
    }

    override fun onResume() {
        super.onResume()
        uiDelegater.resume()
    }

    override fun onPause() {
        super.onPause()
        uiDelegater.pause()
    }

    override fun onStop() {
        super.onStop()
        uiDelegater.pause()
    }

    override fun onDestroy() {
        super.onDestroy()
        uiDelegater.destroy()
    }

}