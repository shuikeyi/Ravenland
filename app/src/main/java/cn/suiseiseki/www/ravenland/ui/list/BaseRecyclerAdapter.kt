package com.sumavision.www.sumalab.ui.list

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import cn.suiseiseki.www.ravenland.ui.list.ListConstants
import cn.suiseiseki.www.ravenland.ui.list.ListViewModel
import cn.suiseiseki.www.ravenland.ui.list.RecyclerViewModelAdapter

/**
 * Created by shui_keyi on 2017/12/6.
 * Email:shuikeyi92@gmail.com
 */
open class BaseRecyclerAdapter(
        val viewModelList : List<ListViewModel>,
        val extraAdapterMap : Map<Int, RecyclerViewModelAdapter> = HashMap<Int, RecyclerViewModelAdapter>()) : RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    val adapterMap = HashMap<Int, RecyclerViewModelAdapter>(ListConstants.originRecyclerAdapterMap)
    init {
        if(extraAdapterMap.isNotEmpty())
            adapterMap.putAll(extraAdapterMap)
    }
    override fun getItemCount(): Int {
        return viewModelList.size
    }

    open fun getViewModelIndex(position : Int) : Int
    {
        return viewModelList[position].getViewModelIndex()
    }

    override fun getItemViewType(position: Int): Int {
        return getViewModelIndex(position)
    }

    override fun getItemId(position: Int): Long {
        return viewModelList[position].getModelId()
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        adapterMap.get(getItemViewType(position))!!.onBindViewHolder(holder,viewModelList[position])
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return adapterMap.get(viewType)!!.onCreateViewHolder(parent)
    }
}