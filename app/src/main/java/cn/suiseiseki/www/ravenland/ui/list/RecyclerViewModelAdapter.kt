package cn.suiseiseki.www.ravenland.ui.list

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup

/**
 * Created by shui_keyi on 2017/12/6.
 * Email:shuikeyi92@gmail.com
 * 此接口用于Recycler中各模型的Adapter,他们通过ListViewModel的index一一对应
 */
interface RecyclerViewModelAdapter {

    //用于创建Recycler的ViewHolder
    fun onCreateViewHolder(parent : ViewGroup) : RecyclerView.ViewHolder

    //用于Recycler的ViewHolder和数据的绑定
    fun onBindViewHolder(holder: RecyclerView.ViewHolder, listViewModel: ListViewModel)

}