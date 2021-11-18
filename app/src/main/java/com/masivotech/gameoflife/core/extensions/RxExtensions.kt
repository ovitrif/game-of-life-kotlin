package com.masivotech.gameoflife.core.extensions

import io.reactivex.Single
import io.reactivex.disposables.Disposable

/**
 * Subscribes with empty consumers.
 */
fun <T : Any> Single<T>.consume(): Disposable = subscribe({}, {})
