package com.sumavision.www.sumalab.ui.list.common

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import cn.suiseiseki.www.ravenland.R
import cn.suiseiseki.www.ravenland.extensions.inflate
import cn.suiseiseki.www.ravenland.ui.list.ListViewModel
import cn.suiseiseki.www.ravenland.ui.list.ListViewModelAdapter
import cn.suiseiseki.www.ravenland.ui.list.RecyclerViewModelAdapter


/**
 * Created by shui_keyi on 2017/12/6.
 * Email:shuikeyi92@gmail.com
 */
class LoadingAdapter : ListViewModelAdapter, RecyclerViewModelAdapter {
    override fun onBindView(listViewModel: ListViewModel, context: Context, container: ViewGroup): View {
        val view = LayoutInflater.from(context).inflate(R.layout.viewmodel_loading,container,false)
        return view
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, listViewModel: ListViewModel) {
    }

    override fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder {
        return LoadingViewHolder(parent)
    }

    class LoadingViewHolder(parent: ViewGroup)
        : RecyclerView.ViewHolder(parent.inflate(R.layout.viewmodel_loading))
}