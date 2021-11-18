package com.masivotech.gameoflife.di

import com.masivotech.gameoflife.ui.MainActivity
import com.masivotech.gameoflife.ui.ViewModelsModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, ViewModelsModule::class])
interface AppGraph {

    fun inject(mainActivity: MainActivity)
}
