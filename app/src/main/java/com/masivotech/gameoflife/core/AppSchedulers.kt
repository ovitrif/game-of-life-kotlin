package com.masivotech.gameoflife.core

import com.masivotech.gameoflife.testing.OpenForTesting
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

/**
 * Abstraction over RxJava Schedulers
 */
@OpenForTesting
class AppSchedulers @Inject constructor() {

    /**
     * RxJava's io scheduler, intended for IO-bound work
     * @see io.reactivex.schedulers.Schedulers.io
     */
    val io = Schedulers.io()

    /**
     * RxAndroid's scheduler for work on android's main thread
     * @see io.reactivex.android.schedulers.AndroidSchedulers.mainThread
     */
    val ui = AndroidSchedulers.mainThread() as Scheduler

    /**
     * RxJava's computation scheduler, intended for computation-bound work
     * @see io.reactivex.schedulers.Schedulers.computation
     */
    val computation = Schedulers.computation()
}
