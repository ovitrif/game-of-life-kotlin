package com.masivotech.gameoflife

import android.app.Application
import com.masivotech.gameoflife.di.AppGraph
import com.masivotech.gameoflife.di.AppModule
import com.masivotech.gameoflife.di.DaggerAppGraph

class App : Application() {

    lateinit var container: AppGraph

    override fun onCreate() {
        super.onCreate()
        INSTANCE = this
        container = initDependenciesContainer()
    }

    private fun initDependenciesContainer(): AppGraph {
        return DaggerAppGraph.builder()
            .appModule(AppModule(this))
            .build()
    }

    companion object {
        @get:Synchronized
        lateinit var INSTANCE: App
            private set
    }
}
