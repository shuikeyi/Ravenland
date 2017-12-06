package com.sumavision.www.sumalab.ui.list.common

import cn.suiseiseki.www.ravenland.ui.list.LOADING_VIEWMODEL_INDEX
import cn.suiseiseki.www.ravenland.ui.list.ListViewModel

/**
 * Created by shui_keyi on 2017/12/6.
 * Email:shuikeyi92@gmail.com
 */
class LoadingViewModel : ListViewModel {
    override fun getViewModelIndex(): Int {
        return LOADING_VIEWMODEL_INDEX
    }
}