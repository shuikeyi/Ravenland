package cn.suiseiseki.www.ravenland.ui.list

import com.sumavision.www.sumalab.ui.list.common.LoadingAdapter

/**
 * Created by shui_keyi on 2017/12/6.
 * Email:shuikeyi92@gmail.com
 */
const val NO_ID = -19921128L
const val LOADING_VIEWMODEL_INDEX = -10001
object ListConstants{
    val originListAdapterMap = HashMap<Int, ListViewModelAdapter>().apply {
        put(LOADING_VIEWMODEL_INDEX,LoadingAdapter())
    }

    val originRecyclerAdapterMap = HashMap<Int, RecyclerViewModelAdapter>().apply {
        put(LOADING_VIEWMODEL_INDEX,LoadingAdapter())
    }
}