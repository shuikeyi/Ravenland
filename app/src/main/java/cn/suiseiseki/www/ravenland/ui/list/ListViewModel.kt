package cn.suiseiseki.www.ravenland.ui.list

import cn.suiseiseki.www.ravenland.ui.ViewModel


/**
 * Created by shui_keyi on 2017/12/6.
 * Email:shuikeyi92@gmail.com
 * 此接口用于列表中各模型（数据)
 */
interface ListViewModel : ViewModel {

    //获取此Model的编号
    fun getViewModelIndex() : Int

    //获取此Model对应Item的Id
    fun getModelId() : Long = NO_ID


}