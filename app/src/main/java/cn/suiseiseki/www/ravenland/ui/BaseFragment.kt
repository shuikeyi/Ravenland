package com.sumavision.www.sumalab.ui

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * Created by shui_keyi on 2017/12/5.
 * Email:shuikeyi92@gmail.com
 */
abstract class BaseFragment : Fragment(),UiAction {

    protected var attachedActivty : Activity? = null
    open val uiDelegater by lazy {
        UiBaseDelegate(this.activity)
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater?.inflate(getLayoutId(),container,false)
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initData(savedInstanceState)
        setListener()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is Activity) {
            this.attachedActivty= context
        }
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
        uiDelegater.stop()
    }

    override fun onDetach() {
        super.onDetach()
        attachedActivty = null
    }

    override fun onDestroyView() {
        super.onDestroyView()
        uiDelegater.destroy()
    }
}