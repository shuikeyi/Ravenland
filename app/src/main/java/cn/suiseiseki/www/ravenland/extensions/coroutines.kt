package cn.suiseiseki.www.ravenland.extensions

import kotlinx.coroutines.experimental.*

/**
 * Created by shui_keyi on 2017/12/7.
 * Email:shuikeyi92@gmail.com
 */

/**
 * 根据系统内核获取合理的线程池大小，作为异步线程的上下文
 */
var threadPool = newFixedThreadPoolContext(Runtime.getRuntime().availableProcessors() * 2, "ThreadPool")

/**
 * 在主协程中顺序执行
 *
 * 该函数会阻塞代码继续执行
 */
inline fun runOnCoroutines( noinline job:suspend () -> Unit,delayTime: Long = 0) = runBlocking {
    if(delayTime > 0)
         delay(delayTime)
    job()
}


/**
 * 在工作线程中顺序执行
 *
 * 该函数会阻塞代码继续执行
 */
inline fun runOnWorkCoroutines(noinline job:suspend () -> Unit,delayTime: Long = 0) = runBlocking(threadPool) {
    delay(delayTime)
    job()
}

/**
 * 带返回值的并发执行
        */
inline fun <T> runAsync(noinline job: suspend () -> T,delayTime: Long = 0) : Deferred<T>
{
    return async(threadPool){
        if(delayTime > 0)
            delay(delayTime)
        job()
    }
}

/**
 * 不带返回值的并发
        */
inline fun <T> launchAsync(noinline job:suspend () -> T,delayTime: Long = 0) = launch(threadPool){
    if(delayTime > 0)
        delay(delayTime)
    job()
}

/**
 * 在Android UI线程中执行
 * 此方法用于协程上下文调度
 */
inline fun <T> runOnUiCoroutines(noinline job:suspend  () -> T) = launch(Unconfined) {
    job()
}

/**
 * 将一个函数包装为suspend类型函数，以供协程调度
 * intervalTask为周期性重复任务
 */
suspend inline fun <T> suspendTask(crossinline function:() -> T,delayTime: Long = 0)
{
    if(delayTime > 0)
        delay(delayTime)
    function()
}

suspend inline fun <T> intervalTask(crossinline function: () -> T,times : Int = 1,delayTime: Long = 0)
{
    repeat(times){
        if(delayTime>0)
            delay(delayTime)
        function()
    }
}

