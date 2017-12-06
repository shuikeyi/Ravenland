package cn.suiseiseki.www.ravenland.ui.list

import android.content.Context
import android.view.View
import android.view.ViewGroup

/**
 * Created by shui_keyi on 2017/12/6.
 * Email:shuikeyi92@gmail.com
 * 此接口用于列表中各模型的Adapter,他们通过ListViewModel的index一一对应
 */
interface ListViewModelAdapter {

    //获取与ViewModel绑定后的View
    fun onBindView(listViewModel: ListViewModel, context: Context, container : ViewGroup) : View


}