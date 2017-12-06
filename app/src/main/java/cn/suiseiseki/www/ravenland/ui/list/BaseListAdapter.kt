package com.sumavision.www.sumalab.ui.list

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import cn.suiseiseki.www.ravenland.ui.list.ListConstants
import cn.suiseiseki.www.ravenland.ui.list.ListViewModel
import cn.suiseiseki.www.ravenland.ui.list.ListViewModelAdapter

/**
 * Created by shui_keyi on 2017/12/6.
 * Email:shuikeyi92@gmail.com
 */
open class BaseListAdapter(
        val viewModelList : List<ListViewModel>,
        val context: Context,
        extraAdapterMap : Map<Int, ListViewModelAdapter> = HashMap<Int, ListViewModelAdapter>()) : BaseAdapter() {

    val adapterMap = HashMap<Int, ListViewModelAdapter>(ListConstants.originListAdapterMap)
    init {
        if(extraAdapterMap.isNotEmpty())
            adapterMap.putAll(extraAdapterMap)
    }
    override fun getCount() = viewModelList.size

    override fun getItem(position: Int): ListViewModel {
        return viewModelList[position]
    }

    fun addAdapter(viewModelIndex : Int,adapter : ListViewModelAdapter)
    {
        adapterMap.put(viewModelIndex,adapter)
    }

    open fun getViewModelIndex(position : Int) : Int
    {
        return viewModelList[position].getViewModelIndex()
    }

    override fun getItemId(position: Int): Long {
        return viewModelList[position].getModelId()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val viewModelIndex = getViewModelIndex(position)
        val adapter = adapterMap.get(viewModelIndex)!!
        val view = adapter.onBindView(getItem(position),context,parent)
        return view
    }

}